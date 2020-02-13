package com.isabaev.converterapp.repository.impl;


import com.isabaev.converterapp.entity.Valute;
import com.isabaev.converterapp.repository.ValuteRepository;
import com.isabaev.converterapp.repository.ValuteXMLRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;


import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ValuteXMLRepositoryImpl implements ValuteXMLRepository {

    private Date dateOfUpdate;

    private final String fromURL = "http://www.cbr.ru/scripts/XML_daily.asp";
    private final String toFile = "Valute data from internet/valute.xml";
    private final int connectionTimeout = 1000;
    private final int readTimeout = 1000;



    @Override
    public void downloadValuteDataXML() {

        try {
            URL url = new URL(fromURL);
            File file = new File(toFile);

            FileUtils.copyURLToFile(url, file, connectionTimeout, readTimeout);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public List<Valute> getListOfValuteFromXML() {

        List<Valute> list = new ArrayList<>();

        try {

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();                              // Создается построитель документа
            Document document = documentBuilder.parse(toFile);          // Создается дерево DOM документа из файла
            Node root = document.getDocumentElement();                  // Получаем корневой элемент
            NodeList nodeList = root.getChildNodes();                    // Просматриваем все подэлементы корневого - т.е. все валюты


            String stringDate = root.getAttributes().item(0).getTextContent();
            Date currentDate = new SimpleDateFormat("dd.MM.yyyy").parse(stringDate);


            for (int i = 0; i < nodeList.getLength(); i++) {

                Node node = nodeList.item(i);

                if (node.getNodeType() != Node.TEXT_NODE) {   // Если нода не текст, то это валюта - заходим внутрь

                    NodeList valuteProps = node.getChildNodes();

                    Valute dbValute = new Valute();
                    dbValute.setActualDate(currentDate);

                    for (int j = 0; j < valuteProps.getLength(); j++) {

                        Node nodeProp = valuteProps.item(j);

                        if (nodeProp.getNodeType() != Node.TEXT_NODE) { // Если нода не текст, то это один из параметров книги - печатаем

                            String nodeName = nodeProp.getNodeName();
                            String nodeValue = nodeProp.getChildNodes().item(0).getTextContent();

                            switch (nodeName) {
                                case ("NumCode"):
                                    dbValute.setNumCode(nodeValue);
                                    break;
                                case ("CharCode"):
                                    dbValute.setCharCode(nodeValue);
                                    break;
                                case ("Nominal"):
                                    dbValute.setNominal(Integer.parseInt(nodeValue));
                                    break;
                                case ("Name"):
                                    dbValute.setName(nodeValue);
                                    break;
                                case ("Value"):
                                    dbValute.setValue(Double.parseDouble(nodeValue.replace(",", ".")));
                                    break;
                            }


                        }

                    }

                    list.add(dbValute);
                }
            }

            this.dateOfUpdate = currentDate;


        } catch (ParserConfigurationException | SAXException | IOException | ParseException ex) {
            ex.printStackTrace(System.out);
        }

        return list;

    }



    public Date getDateOfUpdate() {
        return dateOfUpdate;
    }

}
