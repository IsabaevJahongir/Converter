package com.isabaev.converterapp.repository;

import com.isabaev.converterapp.entity.Valute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValuteRepository extends JpaRepository<Valute, Long> {
}
