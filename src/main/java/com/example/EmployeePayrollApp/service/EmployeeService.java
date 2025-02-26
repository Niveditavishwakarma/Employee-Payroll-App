package com.example.EmployeePayrollApp.service;
import com.example.EmployeePayrollApp.dto.EmployeeDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class EmployeeService {

    private final List<EmployeeDTO> employeeList = new ArrayList<>();
    private int employeeIdCounter = 1;

    public List<EmployeeDTO> getAllEmployees() {
        return employeeList;
    }

    public EmployeeDTO getEmployeeById(int id) {
        return employeeList.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        employeeDTO.setId(employeeIdCounter++);
        employeeList.add(employeeDTO);
        return employeeDTO;
    }

    public EmployeeDTO updateEmployee(int id, EmployeeDTO updatedEmployee) {
        for (EmployeeDTO emp : employeeList) {
            if (emp.getId() == id) {
                emp.setName(updatedEmployee.getName());
                emp.setSalary(updatedEmployee.getSalary());
                return emp;
            }
        }
        return null;
    }

    public boolean deleteEmployee(int id) {
        return employeeList.removeIf(emp -> emp.getId() == id);
    }
}
