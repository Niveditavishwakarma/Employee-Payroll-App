package com.example.EmployeePayrollApp.model;

import jakarta.persistence.*;

@Entity
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

        public EmployeePayrollData() {
        }

        public EmployeePayrollData(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public double getSalary() { return salary; }
        public void setSalary(double salary) { this.salary = salary; }
    }


