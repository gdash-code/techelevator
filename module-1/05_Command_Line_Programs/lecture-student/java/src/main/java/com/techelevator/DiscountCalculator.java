package com.techelevator;

import java.sql.SQLOutput;
import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount percent in whole numbers): ");
        String userDiscPercentage = myScanner.nextLine();

        System.out.println("You Entered: " + userDiscPercentage);



        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");
        String userPrices = myScanner.nextLine();

        System.out.println("You Entered: " + userPrices);

        // rely on wrapper classes to convert strings

        double discount = Double.parseDouble(userDiscPercentage);

        String[] strArrayPrices = userPrices.split(" ");
                // Hungarian notation the first word is the type

        for(int i = 0; i < strArrayPrices.length; i++){
            //System.out.println(strArrayPrices[i]);

            double originalPrice = Double.parseDouble(strArrayPrices[i]);

            double discAmount = originalPrice * (discount/100.0);

            double salePrice = originalPrice - discAmount;

            System.out.println("Original Price: " + originalPrice + "Discount: " + discAmount + "Sale Price: " + salePrice);

        }






    }

}