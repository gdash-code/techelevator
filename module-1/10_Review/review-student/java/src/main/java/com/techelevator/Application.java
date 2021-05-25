package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.swing.UIManager.put;

public class Application {

    //Instance variable
    private List<Department> departments = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private Map<String,Project> projects = new HashMap<>();

    /**
     * The main entry point in the application
     * @param args
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
        departments.add(new Department(1, "Marketing"));
        departments.add(new Department(2, "Sales"));
        departments.add(new Department(3, "Engineering"));

    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");
        for (Department list : departments) {
            System.out.println(list.getName());
        }

    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {
        Employee deanJohnson = new Employee();
        deanJohnson.setEmployeeId(1);
        deanJohnson.setFirstName("Dean");
        deanJohnson.setLastName("Johnson");
        deanJohnson.setEmail("djohnson@teams.com");
        deanJohnson.setDepartment(departments.get(2));
        deanJohnson.setSalary(Employee.STARTING_SALARY);
        deanJohnson.setHireDate("08/21/2020");
        employees.add(deanJohnson);
        employees.add(new Employee(2, "Angie", "Smith", "asmith@teams.com", departments.get(2), "08/21/2020"));
        employees.get(1).raiseSalary(10.00);
        employees.add(new Employee(3, "Margaret", "Thompson", "mthompson@teams.com", departments.get(0), "08/21/2020"));

    }



    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");
        for (Employee list : employees) {
            System.out.println(list.getFullName() + " " + list.getSalary() + " " + list.getDepartment().getName());
        }

    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {
        Project teamsProject = new Project("TEams", "Project Management Software", "10/10/2020", "11/10/2020");
        List<Employee> engineeringTeam = new ArrayList<Employee>();
        for(Employee list : employees){
            if(list.getDepartment().equals(departments.get(2))){
                engineeringTeam.add(list);
            }
        }
        teamsProject.setTeamMembers(engineeringTeam);
        projects.put("TEams", teamsProject);

    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {
        Project marketingProject = new Project("Marketing Landing Page" , "Lead Capture Landing Page for Marketing",
                "10/10/2020", "11/10/2020");
        List <Employee> marketingTeam = new ArrayList<Employee>();
        for(Employee list : employees){
            if(list.getDepartment().equals(departments.get(0))){
                marketingTeam.add(list);
            }

            marketingProject.setTeamMembers(marketingTeam);
            projects.put("Marketing Landing Page", marketingProject);
        }


    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
        for(Map.Entry<String, Project> list: projects.entrySet()){
            System.out.println(list.getKey() + ": " + list.getValue().getTeamMembers().size());
        }

    }

}
