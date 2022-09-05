package com.example.beclothesshop.repositories;


import com.example.beclothesshop.common.enums.ERole;
import com.example.beclothesshop.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);

    Role findByName(String name);
}
