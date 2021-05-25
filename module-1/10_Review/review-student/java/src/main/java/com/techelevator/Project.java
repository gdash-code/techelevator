package com.techelevator;

import java.util.List;
import java.awt.datatransfer.StringSelection;
import java.awt.*;

public class Project{
    private String name;
    private String description;
    private String startDate;
    private String dueDate;
    private List <Employee> teamMembers;

    public String  getName(){return name;}
    public String getDescription(){return description;}
    public String  getStartDate(){return startDate;}
    public String  getDueDate(){return dueDate;}
    public List  <Employee> getTeamMembers(){
        return teamMembers;}

    public void setTeamMembers(List <Employee> teamMembers) {
        this.teamMembers = teamMembers;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Project(String name, String description,String startDate, String dueDate){
        this.name=name;
        this.description=description;
        this.startDate=startDate;
        this.dueDate=dueDate;
    }
}