package com.isabaev.converter.app.repository;

import com.isabaev.converter.app.entity.Valute;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface XMLRepository {

    void downloadXMLValuteData();
    List<Valute> getListOfValuteFromXML();
    Date getDateWhenXMLFileWasDownloadedFromInternet();
    Date getDateFromXMLFile();

}
