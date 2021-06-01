package com.techelevator.crm;

import java.util.ArrayList;
import java.util.List;

public class Pet {

    private String name;
    private String species;
    private List<String> vaccinations = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setVaccinations(List<String> vaccinations) {
        this.vaccinations = vaccinations;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public List<String> getVaccinations() {
        return vaccinations;
    }

    public Pet(String name, String species){
        this.name = name;
        this.species = species;
    }

    public String listVaccinations(){
        StringBuilder sb = new StringBuilder();

        int vaxCounter = 0;

        for(String vax : vaccinations){ //once in for each loop each object becomes individual within the objects list, so can no longer get all objects
            sb.append(vax); //if the index of the current vax is not the end of the current list add a comma otherwise add nothing

            sb.append(vaxCounter < vaccinations.size() - 1? ", " : "" );

            vaxCounter++;
        }

        return sb.toString();
    }

    public void addVaccination(String vaccination){
        this.vaccinations.add(vaccination);
    }


}
