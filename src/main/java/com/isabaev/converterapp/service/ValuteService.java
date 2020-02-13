package com.isabaev.converterapp.service;


import com.isabaev.converterapp.entity.Valute;
import com.isabaev.converterapp.repository.ValuteRepository;
import com.isabaev.converterapp.repository.ValuteXMLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValuteService {

    @Autowired
    ValuteRepository valuteRepo;

    @Autowired
    ValuteXMLRepository xmlRepo;

    public ValuteService() {
    }

    public void updateValuteDataBase() {

        System.out.println("============================");
        System.out.println("============================");
        System.out.println("============================");
        System.out.println("Update of data base!!!!");
        xmlRepo.downloadValuteDataXML();
        List<Valute> valuteList = xmlRepo.getListOfValuteFromXML();

        for (Valute valute : valuteList) {
            valuteRepo.save(valute);
        }
    }


    public List<Valute> getActualValutes() {
        return valuteRepo.findAll();
    }
}
