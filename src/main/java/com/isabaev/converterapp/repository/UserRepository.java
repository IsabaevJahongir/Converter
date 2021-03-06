package com.isabaev.converterapp.repository;

import com.isabaev.converterapp.entity.Conversion;
import com.isabaev.converterapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
