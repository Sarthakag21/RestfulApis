package com.employee.Database;

import com.employee.Entity.expenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface expenseDatabase extends JpaRepository<expenseEntity, Integer> {
}
