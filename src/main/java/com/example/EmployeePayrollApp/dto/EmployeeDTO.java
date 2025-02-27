package com.example.EmployeePayrollApp.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private int id;
    @NotNull(message = "Name cannot be null")
    @Pattern(regexp = "^[A-Za-z ]{3,50}$", message = "Name must be between 3-50 characters and contain only letters and spaces")
    private String name;
    private double salary;


}
