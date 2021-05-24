package com.techelevator;

public class FruitTree {

    private String typeOfFruit; //the type of fruit on the tree
    private int piecesOfFruitLeft;  // the number of remaining pieces on the tree


    //constructor
    public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
        this.typeOfFruit = typeOfFruit;
        System.out.println("You have chosen " + typeOfFruit);
        this.piecesOfFruitLeft = startingPiecesOfFruit;
    }

    //methods

    public boolean pickFruit(int numberOfPiecesToRemove) {
        if(piecesOfFruitLeft >= numberOfPiecesToRemove){
            piecesOfFruitLeft = piecesOfFruitLeft - numberOfPiecesToRemove;
            return true;
        }else {
            return false;
        }
    }
        public String getTypeOfFruit(){
            return typeOfFruit;
        }

        public int getPiecesOfFruitLeft() {
            return piecesOfFruitLeft;
        }



    }



