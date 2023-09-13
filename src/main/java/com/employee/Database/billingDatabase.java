package com.employee.Database;

import com.employee.Entity.billingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface billingDatabase extends JpaRepository<billingEntity, Integer> {
}
