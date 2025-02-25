package com.example.EmployeePayrollApp.service;
import com.example.EmployeePayrollApp.model.EmployeePayrollData;
import com.example.EmployeePayrollApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    //service methods here
    public List<EmployeePayrollData> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeePayrollData getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public EmployeePayrollData addEmployee(EmployeePayrollData employee) {
        return employeeRepository.save(employee);
    }

    public EmployeePayrollData updateEmployee(int id, EmployeePayrollData updatedEmployee) {
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
