package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class QuizMaker {



	//Display first question
	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);

		String filePath = "";

		File searchFile = new File(filePath);

		//Prompt user for input filepath and validate
		while(!searchFile.isFile() && !searchFile.exists()){
			System.out.println("Enter the fully qualified name of the file " +
					"to read in for quiz questions");
			filePath = userInput.nextLine();
			searchFile = new File(filePath);
		}

	}

}

//Create a class that holds a quizz question, available answers, and correct answer
//Create a list of Questions with each question