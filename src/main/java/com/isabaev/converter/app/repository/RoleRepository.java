package com.isabaev.converter.app.repository;


import com.isabaev.converter.app.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
