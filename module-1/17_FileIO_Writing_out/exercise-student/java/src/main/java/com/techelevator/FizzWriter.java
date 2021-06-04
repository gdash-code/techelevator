package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		String filePath;

		//Destination File
		System.out.println("What is the destination file?");
		filePath = myScanner.nextLine();
		System.out.println("Destination file: " + filePath);
		//Instantiate!
		File outputFile = new File(filePath);

		if (outputFile.exists()){
			System.out.println(outputFile.getName() + " will overwrite");
			System.out.println("---------------");
		}

		String output = "";

			try (PrintWriter writer = new PrintWriter(outputFile)){
					for (int i = 1; i <= 300; i++) {
						if (i % 3 == 0 && i % 5 == 0){
							output = "FizzBuzz";
					} else if (i % 3 == 0 || (Integer.toString(i).contains("3"))) {
						output = "Fizz";
					} else if ((i % 5 == 0) || (Integer.toString(i).contains("5"))){
						output = "Buzz";
					}else{
							output = Integer.toString(i);
					}
						writer.println(output);
				}
					} catch (FileNotFoundException fileNotFoundException) {
				fileNotFoundException.printStackTrace();
			}


				}
			}




