package com.techelevator;

import java.text.NumberFormat;
import java.util.*;

public class Application {

    private final List<Department> departments = new ArrayList<>();
    private final List<Employee> employees = new ArrayList<>();
    private final Map<String,Project> projects = new HashMap<>();

    /**
     * The main entry point in the application
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {

        // create some departments
        createDepartments();

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!
        Employee angie = employees.get(1);
        angie.raiseSalary(10);

        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();
        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();

    }

    /**
     * Create departments and add them to the collection of departments
     */
    private void createDepartments() {
        Department marketing = new Department(1,"Marketing");
        Department sales = new Department(2,"Sales");
        Department engineering = new Department(3, "Engineering");

        departments.add(marketing);
        departments.add(sales);
        departments.add(engineering);
    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");
        for(Department department : departments) {
            System.out.println(department.getName());
        }
    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {
        Department engineering = departments.get(2);
        Department marketing = departments.get(0);

        //*** Part of bonus challenge solution:
        //Department engineering = getDepartmentByName("Engineering");
        //Department marketing = getDepartmentByName("Marketing");
        //***
        
        // Employee #1 - using no args constructor
        Employee dean = new Employee();
        dean.setEmployeeId(1);
        dean.setFirstName("Dean");
        dean.setLastName("Johnson");
        dean.setEmail("djohnson@teams.com");
        dean.setSalary(Employee.DEFAULT_STARTING_SALARY);
        dean.setDepartment(engineering);
        dean.setHireDate("08/21/2020");

        // Employee #2 - using all args constructor
        Employee angie = new Employee(2,"Angie","Smith", "asmith@teams.com", engineering, "08/21/2020");
        // Employee #3 - using all args constructor
        Employee margaret = new Employee(3,"Margaret","Thompson", "mthompson@teams.com", marketing, "08/21/2020");

        employees.add(dean);
        employees.add(angie);
        employees.add(margaret);
    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        for(Employee employee : employees) {
            System.out.println(employee.getFullName() + " (" + currency.format(employee.getSalary()) + ") " + employee.getDepartment().getName());
        }
    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {
        // Project #1 - TEams Project Management
        Project teams = new Project("TEams", "Project Management Software", "10/10/2020", "11/10/2020");

        // add all employees where department is engineering to the teams project
        List<Employee> engineeringTeam = new ArrayList<>();
        for(Employee employee : employees) {
            if( employee.getDepartment().getName().equals("Engineering")) {
                engineeringTeam.add(employee);
            }
        }
        teams.setTeamMembers(engineeringTeam);

        // the key should be the name of the project
        projects.put(teams.getName(),teams);
    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {
        // Project #2 - Marketing Landing Page
        Project landingPage = new Project("Marketing Landing Page",
                "Lead Capture Landing Page for Marketing",
                "10/10/2020",
                "10/17/2020");


        // add all employees where department is marketing to the landing page project
        List<Employee> marketingTeam = new ArrayList<>();
        for(Employee employee : employees) {
            if( employee.getDepartment().getName().equals("Marketing")) {
                marketingTeam.add(employee);
            }
        }
        landingPage.setTeamMembers(marketingTeam);

        projects.put(landingPage.getName(),landingPage);
    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
        for(Map.Entry<String, Project> project : projects.entrySet()) {
            System.out.println(project.getValue().getName() + ": " + project.getValue().getTeamMembers().size());
        }
    }

    
    /**
     * Bonus challenge: Find a department by name.
     */
    private Department getDepartmentByName(String departmentName)
    {
        for (Department department : departments)
        {
            if (department.getName().equals(departmentName))
            {
                return department;
            }
        }
        return null;
    }
}
