package com.example.EmployeePayrollApp.controller;
import com.example.EmployeePayrollApp.dto.EmployeeDTO;
import com.example.EmployeePayrollApp.model.EmployeePayrollData;
import com.example.EmployeePayrollApp.service.EmployeeService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employees")
public class EmployeePayrollController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<EmployeePayrollData>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeePayrollData> getEmployeeById(@PathVariable int id) {
        EmployeePayrollData employee = employeeService.getEmployeeById(id);
        return employee != null ? new ResponseEntity<>(employee, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeePayrollData> addEmployee(@Valid @RequestBody EmployeeDTO employee) {
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeePayrollData> updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeeDTO updatedEmployee) {
        EmployeePayrollData employee = employeeService.updateEmployee(id, updatedEmployee);
        return employee != null ? new ResponseEntity<>(employee, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        return employeeService.deleteEmployee(id)
                ? new ResponseEntity<>("Employee Deleted Successfully", HttpStatus.OK)
                : new ResponseEntity<>("Employee Not Found", HttpStatus.NOT_FOUND);
    }
}




