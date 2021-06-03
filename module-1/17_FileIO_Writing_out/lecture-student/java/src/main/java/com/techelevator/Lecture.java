package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {


		/*
		 * The java.io.File class is a representation of file and directory path names.
		 * It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and
		 * Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

		//Prompt user for file name or directory and instantiate File object?
		Scanner userInput = new Scanner(System.in);
		String path = "";

		System.out.println("Enter the path of a file or directory: ");
		path = userInput.nextLine();

		File target = new File(path);

		System.out.println(); //blank empty line

		//Inspect the File system by Validating (path) and determining its type

		if(target.exists()){
			System.out.println("Name: " + target.getName());
			System.out.println("Absolute Path: " + target.getAbsolutePath());
			System.out.println("Canonical Path: " + target.getCanonicalPath());

			if(target.isFile() || target.isDirectory()){

				System.out.println( ((target.isFile()) )? "Type: File" : "Type Directory");

			}

			System.out.println("Size:" + target.length()); //measuring byte size

		}else{
			System.out.println(target.getName() + " does not exist");
		}

		//Create a directory

		System.out.println("\n Time to create a directory");
		System.out.println("Enter the pathname of the new Directory: ");

		String newDirectoryName = userInput.nextLine(); //prompted user captured input

		File newDirectory = new File(newDirectoryName);

		if(!newDirectory.exists()){
			//Create it
			if(newDirectory.mkdir() ){
				System.out.println(newDirectory.getName() + " was created as a new directory");
			}else{
				System.out.println("Sorry, unable to create the new directory " + newDirectory.getName());
				System.exit(1); //there was an abnormal termination classified as 1
			}
		}else{
			System.out.println("Directory '" + newDirectory.getName() + "' already exists");
		}

		//Create a file

		System.out.println("\n Time to create a file in the new directory ... ");
		System.out.println("Please enter the new file's name: ");

		String fileName = userInput.nextLine();

		File newFile = new File(newDirectory, fileName); //newFile represents that file system object a logical file until we invoke methods

		newFile.createNewFile();


		/*//I've repeated code twice, if there is a third time that is a code-smell to refactor
		System.out.println("Name: " + newFile.getName());
		System.out.println("Absolute Path: " + newFile.getAbsolutePath());
		System.out.println("Canonical Path: " + newFile.getCanonicalPath());
		System.out.println("Size:" + newFile.length());*/

		printFileDetails(newFile);

		//Let's try again in overwrite mode

		System.out.println("\nTime to write something to the file in overwrite mode");
		System.out.println("Enter the message you want to write to the file: ");

		String userMessage = userInput.nextLine();

		//immediately wrap with try with resources
		try(PrintWriter fileWriter = new PrintWriter(new FileOutputStream(newFile.getAbsoluteFile(), true))){

			fileWriter.write(userMessage);

		} catch (IOException ioEx){
			System.out.println("Something bad happened writing ");
			System.out.println(ioEx.getMessage());
			System.exit(1);
		}

		printFileDetails(newFile);


	}
		public static void printFileDetails(File fileSystemObject) throws IOException{
			System.out.println("Name: " + fileSystemObject.getName());
			System.out.println("Absolute Path: " + fileSystemObject.getAbsolutePath());
			System.out.println("Canonical Path: " + fileSystemObject.getCanonicalPath());
			System.out.println("Size:" + fileSystemObject.length());
		}
}
