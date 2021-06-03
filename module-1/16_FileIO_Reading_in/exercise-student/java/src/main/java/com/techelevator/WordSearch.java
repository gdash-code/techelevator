package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);

		String filepath = "";
		String searchWord = "";
		String caseSensitive = "";

		File searchFile = new File(filepath);
		//Validate File is a file and that it exists

		//Prompt user for file
		while (!searchFile.isFile() || !searchFile.exists()) {
			System.out.println("What is the fully qualified name of the file that should be searched?");
			filepath = userInput.nextLine();

			//Create file reference to path
			searchFile = new File(filepath);
		}

		//prompt user for search word
		System.out.println("What is the search word you are looking for?");

		searchWord = userInput.nextLine(); //to lowercase?

		//Prompt user for Case sensitivity?
		System.out.println("Is the word Case Sensitive? 'Y' or 'N' ");
		caseSensitive = userInput.nextLine();


		//Use scanner to check if each line of File .contains() search word
		String searchResults = "";

		if (caseSensitive.equals("N")) {
			try (Scanner fileScanner = new Scanner(searchFile)) {

				Integer lineCounter = 0;


				while (fileScanner.hasNextLine()) {

					lineCounter++;

					String lineToSearch = fileScanner.nextLine();

					if (lineToSearch.toLowerCase().contains(searchWord.toLowerCase())) {
						searchResults += lineCounter.toString() + ") " + lineToSearch + "\n";
					}
				}

			} catch (FileNotFoundException fnfEx) {
				System.out.println("Criss Cross Applesauce Try Again");
			} finally {
				System.out.println(searchResults.trim());
			}

		}
		if (caseSensitive.equals("Y")) {
			try (Scanner fileScanner = new Scanner(searchFile)) {

				Integer lineCounter = 0;


				while (fileScanner.hasNextLine()) {

					lineCounter++;

					String lineToSearch = fileScanner.nextLine();

					if (lineToSearch.contains(searchWord)) {
						searchResults += lineCounter.toString() + ") " + lineToSearch + "\n";
					}
				}

			} catch (FileNotFoundException fnfEx) {
				System.out.println("Criss Cross Applesauce Try Again");
			} finally {
				System.out.println(searchResults.trim());
			}


		}
	}
}