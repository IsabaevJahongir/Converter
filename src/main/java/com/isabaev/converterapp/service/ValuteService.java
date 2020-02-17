package com.isabaev.converterapp.service;


import com.isabaev.converterapp.entity.Valute;
import com.isabaev.converterapp.repository.ValuteRepository;
import com.isabaev.converterapp.repository.XMLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ValuteService {

    @Autowired
    ValuteRepository valuteRepo;

    @Autowired
    XMLRepository xmlRepo;


    public ValuteService() {
    }

    public Valute findValuteById(Long id) {
        return valuteRepo.findById(id).get();
    }


    public List<Valute> getActualValutes() {
        return valuteRepo.getActualValute();
    }


    public boolean updateValuteDataBase() {

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        Date currentDate = null;
        try {
            currentDate = dateFormat.parse(dateFormat.format(new Date()));
        } catch (ParseException e) {
            // Не должно произойти}
        }

        Date dateWhenFileWasDownloaded = xmlRepo.getDateWhenXMLFileWasDownloadedFromInternet();

        if (dateWhenFileWasDownloaded == null || currentDate.compareTo(dateWhenFileWasDownloaded) != 0) {


        /*    System.out.println("Файл либо не загружен либо либо устарел");
            System.out.println("File: was downloaded " + dateWhenFileWasDownloaded);
            System.out.println("Current: " + currentDate);*/

            xmlRepo.downloadXMLValuteData();
            List<Valute> valutes = xmlRepo.getListOfValuteFromXML(); // загружаем дату из xml файла и заодно получаем валютные данные


            Date dateFromXMLFile = xmlRepo.getDateFromXMLFile();
            Date maxDateInDB = valuteRepo.findMaxDateInDB();

            if (maxDateInDB == null || dateFromXMLFile.compareTo(maxDateInDB) > 0) {

        /*
                System.out.println("Новые данные будут загружены в бд");
                System.out.println("XML date: " + dateFromXMLFile);
                System.out.println("Current date: " + maxDateInDB);
                */

                xmlRepo.downloadXMLValuteData();
                List<Valute> valuteList = xmlRepo.getListOfValuteFromXML();

                for (Valute valute : valuteList) {
                    valuteRepo.save(valute);
                }
            } else {
                System.out.println("Данные добавлялись сегодня");
                return false;
            }
        } else {
            System.out.printf("Данные в БД актуальны");
            return false;
        }
        return true;
    }


    public Date findMaxDateOfUpdate() {
        return valuteRepo.findMaxDateInDB();
    }

}
