package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		String filepath = "";
		String searchWord = "";

		File searchFile = new File(filepath);
		//Validate File is a file and that it exists
		//Prompt user for file
		while(searchFile.isFile() == false || searchFile.exists() == false) {
			System.out.println("What is the fully qualified name of the file that should be searched?");
			filepath = userInput.nextLine();
			//Create file reference to path
			searchFile = new File(filepath);
		}
//prompt user for search word
		System.out.println("What is the search word you are looking for?");
		searchWord = userInput.nextLine();


		//Use scanner to check if each line of File .contains() search word
		String searchResults = "";

		try(Scanner fileScanner = new Scanner(searchFile)){

			Integer lineCounter = 0;




			while(fileScanner.hasNextLine()){

				lineCounter++;

				String lineToSearch = fileScanner.nextLine();

				if(lineToSearch.contains(searchWord)){
					searchResults += lineCounter.toString() + ") " + lineToSearch + "\n";
				}
			}

		}catch(FileNotFoundException fnfEx){
			System.out.println("This should not have happened");
		}
		finally {
			System.out.println(searchResults);
		}


	}

}
