package com.isabaev.converterapp.service;

import com.isabaev.converterapp.entity.Conversion;
import com.isabaev.converterapp.entity.User;
import com.isabaev.converterapp.repository.ConversionRepository;
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
        return conversionRepo.findConversionsByDate(date);
    }


}
