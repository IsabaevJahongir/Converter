package com.isabaev.converterapp.repository;

import com.isabaev.converterapp.entity.Valute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ValuteRepository extends JpaRepository<Valute, Long> {

    Optional<Valute> findById(Long id);


    @Query("select MAX(actualDate) from Valute")
    Date findMaxDateInDB();

    @Query(value = "select * from valutes v where actual_date = (Select max(actual_date) from valutes)",
            nativeQuery = true)
    List<Valute> getActualValute();
}
