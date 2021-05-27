package com.techelevator.farm;

public class BarnCat extends FarmAnimal{
    //need more data to satisfy parent constructor
    //doesn't need unique code
    public BarnCat(String name, String sound){
        super(name, sound);
    }
//overriden the superclass get sound farm animal
    @Override
    public void feed(){
        System.out.println("Barn cats feed themselves");
    }
}
