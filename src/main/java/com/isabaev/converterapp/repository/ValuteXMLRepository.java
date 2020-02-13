package com.isabaev.converterapp.repository;

import com.isabaev.converterapp.entity.Valute;

import java.io.File;
import java.util.List;

public interface ValuteXMLRepository {

    void downloadValuteDataXML();
    List<Valute> getListOfValuteFromXML();

}