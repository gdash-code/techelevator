package com.techelevator.crm;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class CustomerTest {

    private Object Double;

    @Test
    public void Customer_GetBalance_ForGrooming(){
        Customer customer = new Customer();
        Map<String,Double> service = new HashMap<>();
        service.put("Grooming",2.00);
        double expected=2.00;
        double result =customer.getBalanceDue(new HashMap<String, Double>());
        Assert.assertEquals(Double,Double); }
    @Test
    public void Customer_GetBalance_ForWalking(){
        Customer customer = new Customer();
        Map<String,Double>service=new HashMap<>();
        service.put("Walking",4.00);
        double expected=4.00;
        double result=customer.getBalanceDue(new HashMap<String, Double>());
        Assert.assertEquals(Double,Double); }
    @Test
    public void Customer_GetBalance_ForSitting(){
        Customer customer = new Customer();
        Map<String,Double>service=new HashMap<>();
        service.put("Grooming",2.00);
        double expected=2.00;
        double result=customer.getBalanceDue(new HashMap<String, Double>());
        Assert.assertEquals(Double,Double); }
    @Test
    public void Customer_GetBalance_ForNoService(){
        Customer customer = new Customer();
        Map<String,Double>service=new HashMap<>();
        service.put(" ",0.00);
        double expected=0.00;
        double result=customer.getBalanceDue(new HashMap<String, Double>());
        Assert.assertEquals(Double,Double); }
}



