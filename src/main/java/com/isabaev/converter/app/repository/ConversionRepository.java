package com.isabaev.converter.app.repository;

import com.isabaev.converter.app.entity.Conversion;
import com.isabaev.converter.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ConversionRepository extends JpaRepository<Conversion, Long> {
    List<Conversion> findConversionsByUser(User user);
    List<Conversion> findConversionsByUserAndDate(User user,Date date);
}
