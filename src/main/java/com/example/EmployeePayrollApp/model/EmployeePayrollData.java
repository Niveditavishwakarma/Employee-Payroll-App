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

        @Temporal(TemporalType.DATE)
        private Date startDate;

        private String note;
        private String profilePic;

        @ElementCollection
        @CollectionTable(name = "EMPLOYEE_DEPARTMENT", joinColumns = @JoinColumn(name = "EMPLOYEE_ID"))
        @Column(name = "DEPARTMENT")
        private List<String> department;

        public EmployeePayrollData() {
        }

    }


