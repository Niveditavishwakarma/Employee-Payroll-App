package com.example.EmployeePayrollApp.service;
import org.modelmapper.ModelMapper;
import com.example.EmployeePayrollApp.dto.EmployeeDTO;
import com.example.EmployeePayrollApp.exception.EmployeeNotFoundException;
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

    @Autowired
    private ModelMapper modelMapper;

    public List<EmployeePayrollData> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeePayrollData getEmployeeById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));
    }

    public EmployeePayrollData addEmployee(EmployeeDTO employeeDTO) {
        EmployeePayrollData employee = modelMapper.map(employeeDTO, EmployeePayrollData.class);
        return employeeRepository.save(employee);
    }

    public EmployeePayrollData updateEmployee(int id, EmployeeDTO updatedEmployee) {
        EmployeePayrollData employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));

        modelMapper.map(updatedEmployee, employee);
        return employeeRepository.save(employee);
    }

    public boolean deleteEmployee(int id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
        employeeRepository.deleteById(id);
        return true;
    }
}


