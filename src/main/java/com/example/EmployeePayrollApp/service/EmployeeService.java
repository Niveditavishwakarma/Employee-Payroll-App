package com.example.EmployeePayrollApp.service;

import com.example.EmployeePayrollApp.dto.EmployeeDTO;
import com.example.EmployeePayrollApp.model.EmployeePayrollData;
import com.example.EmployeePayrollApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeePayrollData> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeePayrollData getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public EmployeePayrollData addEmployee(EmployeeDTO employeeDTO) {
        EmployeePayrollData employee = new EmployeePayrollData();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        return employeeRepository.save(employee);
    }

    public EmployeePayrollData updateEmployee(int id, EmployeeDTO updatedEmployee) {
        EmployeePayrollData employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setName(updatedEmployee.getName());
            employee.setSalary(updatedEmployee.getSalary());
            return employeeRepository.save(employee);
        }
        return null;
    }

    public boolean deleteEmployee(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}


