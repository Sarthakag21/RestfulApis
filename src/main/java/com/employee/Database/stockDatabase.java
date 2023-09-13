package com.employee.Database;

import com.employee.Entity.stockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface stockDatabase extends JpaRepository<stockEntity, Integer> {
}
