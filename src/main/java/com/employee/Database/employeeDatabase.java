package com.employee.Database;

import com.employee.Entity.employeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeDatabase extends JpaRepository<employeeEntity, Integer> {
}
