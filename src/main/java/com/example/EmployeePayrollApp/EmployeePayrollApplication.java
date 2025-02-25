package com.example.EmployeePayrollApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class})

public class EmployeePayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeePayrollApplication.class, args);
	}

}
