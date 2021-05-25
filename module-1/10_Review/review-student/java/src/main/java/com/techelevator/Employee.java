package com.techelevator;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Employee {
        private long employeeId;
        private String firstName;
        private String lastName;
        private String email;
        private double salary;
        private Department department;
        private String hireDate;


        public long getEmployeeId() {
            return employeeId;
        }
        public String getFirstName() {
            return firstName;
        }
        public String getLastName() {
            return lastName;
        }
        public String getEmail() {
            return email;
        }
        public double getSalary() {return salary;}
        public Department getDepartment() {
            return department;
        }
        public String getHireDate() {
            return hireDate;
        }
        public void setEmployeeId(long employeeId) {
            this.employeeId = employeeId;}
        public void setHireDate(String hireDate) {
            this.hireDate = hireDate;
        }
        public void setDepartment(Department department) {
            this.department = department;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        public void setSalary(double salary) {
            this.salary = salary;
        }
        public static final double STARTING_SALARY = 60000.00;
        public Employee(long employeeId, String firstName, String lastName, String email,
                        Department department, String hireDate) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.department = department;
            this.hireDate = hireDate;
            this.salary = STARTING_SALARY;
        }
        public Employee() {
        }
        public String getFullName() {
            return (lastName + "," + firstName);
        }
        public void raiseSalary(double percent) {
            double newSalary = ((percent / 100) * (double)this.salary) + (double)this.salary;
            BigDecimal bd = new BigDecimal(newSalary).setScale(2, RoundingMode.HALF_UP);
            double newSalaryConverted = bd.doubleValue();
            this.salary = newSalaryConverted;}
    }


