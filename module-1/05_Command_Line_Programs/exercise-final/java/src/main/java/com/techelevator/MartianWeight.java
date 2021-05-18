package com.techelevator;

public class MartianWeight {
    /*
    In case you've ever pondered how much you weight on Mars, here's the calculation:
    Wm = We* 0.378
    where 'Wm' is the weight on Mars, and 'We' is the weight on Earth
    
    Write a command line program which accepts a series of Earth weights as command line arguments,
    and displays each Earth weight as itself, and its Martian equivalent.
    
    C:\Users> MartianWeight 98 235 185
    98 lbs.on Earth, is 37 lbs.on Mars.
    235 lbs.on Earth, is 88 lbs.on Mars.
    185 lbs.on Earth, is 69 lbs.on Mars.
    */
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            int earthWeight = Integer.parseInt(args[i]);
            int martianWeight = (int) (earthWeight * .378);

            System.out.println(earthWeight + " lbs. on Earth, is " + martianWeight + " lbs. on Mars.");
        }
    }
}
