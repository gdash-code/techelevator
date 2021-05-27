package com.techelevator;

public class SquareWall extends RectangleWall{

    private int sideLength;

    public SquareWall(String name, String color, int sideLength){
        super(name, color, sideLength, sideLength);
        this.sideLength = sideLength;

    }

    @Override
    public String toString(){
       return getName() + " (" + sideLength + "x" + sideLength + ") square";
    }

}
