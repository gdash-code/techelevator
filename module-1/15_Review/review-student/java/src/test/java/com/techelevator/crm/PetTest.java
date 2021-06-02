package com.techelevator.crm;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PetTest {

        @Test
        public void Pet_ShouldOutPut_VaccinationList(){
            Pet pet=new Pet();
            List<String> vaccinations=new ArrayList<>
                    (Collections.singleton("Rabies, Distemper, Parvo"));
            String expected= "Rabies, Distemper, Parvo";
            String result=pet.listVaccinations(vaccinations);
            Assert.assertEquals(expected,result);
        }

}
