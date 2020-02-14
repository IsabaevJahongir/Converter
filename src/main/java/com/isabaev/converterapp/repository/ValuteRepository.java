package com.isabaev.converterapp.repository;

import com.isabaev.converterapp.entity.Valute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ValuteRepository extends JpaRepository<Valute, Long> {

    Optional<Valute> findById(Long id);

}
