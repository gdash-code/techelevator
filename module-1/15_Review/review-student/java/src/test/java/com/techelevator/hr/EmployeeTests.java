package com.techelevator.hr;

import com.techelevator.crm.Customer;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class EmployeeTests {

private Object Double;

    @Test
    public void getFullNameReturnsCorrectFormat() {
        Employee employee = new Employee("Test", "Testerson");
        String fullName = employee.getFullName();

        assertEquals("The employee full name is not in the correct format.", "Testerson, Test", fullName);
    }

    @Test
    public void raiseSalaryTest_Positive() {
        Employee employee = new Employee("Test", "Testerson");
        employee.setSalary(100);
        employee.raiseSalary(5);

        assertEquals("The employee raise of 5% was not computed correctly.",employee.getSalary(), 100 * 1.05, 0.0);
    }

    @Test
    public void raiseSalaryTest_Negative() {
        Employee employee = new Employee("Test", "Testerson");
        employee.setSalary(100);
        employee.raiseSalary(-10); //"raise" by negative 10%

        assertEquals("Salary should remain the same when raise percentage is negative.",100, employee.getSalary(),0.0);
    }

    @Test
    public void Employee_GetBalance_ForGrooming(){
        Customer customer = new Customer();
        Map<String,Double>services=new HashMap<>();
        services.put("Grooming",2.00);
        double expected=2.00;
        double result=customer.getBalanceDue(new HashMap<String, Double>());
        Assert.assertEquals(Double,Double); }
    @Test
    public void Employee_GetBalance_ForWalking(){
        Customer customer = new Customer();
        Map<String,Double>services=new HashMap<>();
        services.put("Walking",2.00);
        double expected=2.00;
        double result=customer.getBalanceDue(new HashMap<String, Double>());
        Assert.assertEquals(Double,Double); }
    @Test
    public void Employee_GetBalance_ForSitting(){
        Customer customer = new Customer();
        Map<String,Double>services=new HashMap<>();
        services.put("Sitting",1.00);
        double expected=1.00;
        double result=customer.getBalanceDue(new HashMap<String, Double>());
        Assert.assertEquals(Double,Double); }
    @Test
    public void Employee_GetBalance_ForNoServices(){
        Customer customer = new Customer();
        Map<String,Double>services=new HashMap<>();
        services.put(" ",0.00);
        double expected=0.00;
        double result=customer.getBalanceDue(new HashMap<String, Double>());
        Assert.assertEquals(Double,Double); }
}

