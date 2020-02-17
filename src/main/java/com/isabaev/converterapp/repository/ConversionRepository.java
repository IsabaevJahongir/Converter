package com.isabaev.converterapp.repository;

import com.isabaev.converterapp.entity.Conversion;
import com.isabaev.converterapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ConversionRepository extends JpaRepository<Conversion, Long> {
    List<Conversion> findConversionsByUser(User user);
    List<Conversion> findConversionsByDate(Date date);
}
