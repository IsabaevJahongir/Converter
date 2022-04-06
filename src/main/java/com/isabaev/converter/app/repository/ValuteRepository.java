package com.isabaev.converter.app.repository;

import com.isabaev.converter.app.entity.Valute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public interface ValuteRepository extends JpaRepository<Valute, Long> {

    Optional<Valute> findById(Long id);


    @Query("select MAX(actualDate) from Valute")
    Date findMaxDateInDB();

    @Query(value = "select * from valutes v where actual_date = (Select max(actual_date) from valutes)",
            nativeQuery = true)
    List<Valute> getActualValute();
}
