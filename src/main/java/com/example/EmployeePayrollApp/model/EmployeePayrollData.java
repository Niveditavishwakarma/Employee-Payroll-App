package com.example.EmployeePayrollApp.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "EMPLOYEE")
public class EmployeePayrollData {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="ID")
        private int id;

        @Column(name="NAME")
        private String name;

        @Column(name="SALARY")
        private double salary;
        private String gender;
        private Date startDate;
        private String note;
        private String profilePic;
        private List<String> department;

        public EmployeePayrollData() {
        }

        public EmployeePayrollData(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

    }


