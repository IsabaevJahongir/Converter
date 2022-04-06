package com.isabaev.converter.app.service;

import com.isabaev.converter.app.entity.Conversion;
import com.isabaev.converter.app.repository.ConversionRepository;
import com.isabaev.converter.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ConversionsService {

    @Autowired
    ConversionRepository conversionRepo;

    public ConversionsService() {
    }

    public void save(Conversion conversion){
        conversionRepo.save(conversion);
    }

    public List<Conversion> findAllByUser(User user){
        return conversionRepo.findConversionsByUser(user);
    }

    public List<Conversion> findAllByUserAndDate(User user, Date date){
        return conversionRepo.findConversionsByUserAndDate(user, date);
    }


}
