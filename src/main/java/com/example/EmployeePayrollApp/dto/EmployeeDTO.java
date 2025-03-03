package com.example.EmployeePayrollApp.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private int id;

    @NotBlank(message = "Name cannot be empty or whitespace")
    @Pattern(regexp = "^[A-Za-z ]{3,50}$", message = "Name must be between 3-50 characters and contain only letters and spaces")
    private String name;

    @NotNull(message = "Salary cannot be null")
    @Min(value = 10000, message = "Salary must be at least 10,000")
    private double salary;

    @NotBlank(message = "Gender cannot be empty")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
    private String gender;

    @NotNull(message = "Start Date cannot be empty")
    @JsonFormat(pattern = "dd MMM yyyy")
    @PastOrPresent(message = "Start Date should be in the past or present")
    private Date startDate;

    @NotBlank(message = "Note cannot be empty")
    private String note;

    @NotBlank(message = "Profile picture URL cannot be empty")
    private String profilePic;

    @NotEmpty(message = "Department list cannot be empty")
    private List<String> department;



}
