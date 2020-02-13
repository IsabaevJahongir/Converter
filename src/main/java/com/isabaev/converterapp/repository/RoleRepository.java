package com.isabaev.converterapp.repository;


import com.isabaev.converterapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
