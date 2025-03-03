package com.example.EmployeePayrollApp.repository;

import com.example.EmployeePayrollApp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface EmployeeRepository extends JpaRepository<EmployeePayrollData, Integer> {
    List<EmployeePayrollData> findByDepartment(String department);


}


