package com.techelevator.crm;

import java.util.Map;

public interface Billable {

    double getBalanceDue(Map<String, Double> servicesRendered);

}
