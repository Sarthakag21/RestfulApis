package com.employee.serviceInterface;

import com.employee.Entity.adminRegisterEntity;

import java.util.List;
import java.util.Optional;

public interface adminRegisterInterface {
    public void addAdmin(adminRegisterEntity adminRegisterEntity);
    public Optional<adminRegisterEntity> findAdminByID(int id);
    public List<adminRegisterEntity> findAllAdmin();
    public void deleteAdminByID(int id);

}
