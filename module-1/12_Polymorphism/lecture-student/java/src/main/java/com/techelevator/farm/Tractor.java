package com.techelevator.farm;

import java.awt.datatransfer.StringSelection;

public class Tractor implements Singable, Rideable{

    private String name;
    private String sound;

    public Tractor(String name, String sound){
        this.name = name;
        this.sound = sound;
    }
    @Override
    public String getSound(){
        return this.sound;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
