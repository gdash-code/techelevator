package com.techelevator;

public class RectangleWall extends Wall{
    private int length = 0;
    private int height = 0;

    public int getLength() { //means read only Create Rectangle Wall
        return length;
    }

    public int getHeight() {
        return height;
    }

    public RectangleWall(String name, String color){ //implement RectangleWall and solve errors
        super(name, color);
    }

    public RectangleWall(String name, String color, int length, int height){
        super(name, color);
        this.length = length;
        this.height = height;
    }

    public int getArea(){

        return this.length * this.height;

    }
    @Override
    public String toString(){

        //String result = String.format("%1 (%2x%3) rectangle", this.getName(), getLength(), getHeight());

        return getName() + " (" + length + "x" + height + ") rectangle"; //added space

    }
}
