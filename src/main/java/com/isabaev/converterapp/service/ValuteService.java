package com.isabaev.converterapp.service;


import com.isabaev.converterapp.entity.Valute;
import com.isabaev.converterapp.repository.ValuteRepository;
import com.isabaev.converterapp.repository.XMLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Valute findValuteById(Long id){
        return valuteRepo.findById(id).get();
    }

    public List<Valute> getActualValutes() {
        return valuteRepo.findAll();
    }


    public boolean updateValuteDataBase() {

        Date current = new Date();
        Date dateOfUpdate = xmlRepo.dateOfUpdate();

        System.out.println(dateOfUpdate);

        if (dateOfUpdate == null ||
                dateOfUpdate.getDate() != (current.getDate() + 1) ||
                dateOfUpdate.getMonth() != current.getMonth() ||
                dateOfUpdate.getYear() != current.getYear()) {


            xmlRepo.downloadXMLValuteData();
            List<Valute> valuteList = xmlRepo.getListOfValuteFromXML();

            for (Valute valute : valuteList) {
                valuteRepo.save(valute);
            }
            return true;
        }
        return false;
    }

}
