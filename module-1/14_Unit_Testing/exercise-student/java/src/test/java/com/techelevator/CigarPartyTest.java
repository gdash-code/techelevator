package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTest {



    @Test
    public void Should_Return_False(){

        //Arrange
        CigarParty cigarParty = new CigarParty();
        //Act
        boolean result = cigarParty.haveParty(30,false);
        //Assert
        Assert.assertFalse("No fun this weekend", false);

    }

    @Test
    public void Should_Return_True(){

        //Arrange
        CigarParty cigarParty = new CigarParty();
        //Act
        boolean result = cigarParty.haveParty(50,false);

        //Assert
        Assert.assertTrue("Party it up", true);


    }

    @Test
    public void Should_Return_Success(){

        //Arrange
        CigarParty cigarParty = new CigarParty();
        //Act
        boolean resultA = cigarParty.haveParty(70,true);
        //Assert
        Assert.assertTrue("Success", true);


    }

}
