package com.isabaev.converterapp.repository;

import com.isabaev.converterapp.entity.Valute;

import java.io.File;
import java.util.Date;
import java.util.List;

public interface XMLRepository {

    void downloadXMLValuteData();
    List<Valute> getListOfValuteFromXML();
    Date dateOfUpdate();

}
