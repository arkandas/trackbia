package com.arkandas.trackbiaback.repository;

import com.arkandas.trackbiaback.models.BRole;
import com.arkandas.trackbiaback.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(BRole name);
}
