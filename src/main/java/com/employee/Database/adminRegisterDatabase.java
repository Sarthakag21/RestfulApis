package com.employee.Database;

import com.employee.Entity.adminRegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface adminRegisterDatabase extends JpaRepository<adminRegisterEntity, Integer> {
}