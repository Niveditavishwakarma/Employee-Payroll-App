package com.example.EmployeePayrollApp.controller;
import com.example.EmployeePayrollApp.dto.EmployeeDTO;
import com.example.EmployeePayrollApp.model.EmployeePayrollData;
import com.example.EmployeePayrollApp.service.EmployeeService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Slf4j
@Validated
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employees")
public class EmployeePayrollController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<EmployeePayrollData>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeePayrollData> getEmployeeById(@PathVariable int id) {
        EmployeePayrollData employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeePayrollData> addEmployee(@Valid @RequestBody EmployeeDTO employee) {
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeePayrollData> updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeeDTO updatedEmployee) {
        EmployeePayrollData employee = employeeService.updateEmployee(id, updatedEmployee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee Deleted Successfully");
    }

    @GetMapping("/department/{department}")
    public List<EmployeePayrollData> getSalesEmployees() {
        return employeeService.getSalesEmployees();
    }
}




