package com.example.EmployeePayrollApp.repository;

import com.example.EmployeePayrollApp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// hello
    @Repository
    public interface EmployeeRepository extends JpaRepository<EmployeePayrollData, Integer> {
    }


