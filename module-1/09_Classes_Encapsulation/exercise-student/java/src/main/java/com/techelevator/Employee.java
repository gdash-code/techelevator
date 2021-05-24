package com.techelevator;

public class Employee {

        //Instance variables -->private members
        private int employeeId;
        private String firstName;
        private String lastName;
        private String department;
        private double annualSalary;
        //Accessors

    public Employee(int employeeId, String firstName, String lastName, double salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = salary;
    }

    public void raiseSalary(double percent) {
        if (percent > 0.00) {
            annualSalary = annualSalary * (1.0 * (percent / 100));
        }
    }

        public int getEmployeeId(){
            return employeeId;}

        public String getFirstName(){
            return firstName;}

        public String getLastName(){
            return lastName;}


        public double getAnnualSalary(){
            return annualSalary;}

        public String getFullName(){ //derived
            return lastName+", "+firstName;
        }
        public String getDepartment(){
            return department;
        }
        public void setDepartment(String department){
            this.department = department;}

        public void setLastName(String lastName){
        this.lastName = lastName;
                }



        }





