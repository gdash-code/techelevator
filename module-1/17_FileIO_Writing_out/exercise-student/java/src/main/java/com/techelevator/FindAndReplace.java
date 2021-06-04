package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.System.exit;

public class FindAndReplace {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String filePath = "";
        String searchWord = "";
        String replaceWord = "";

        File f = new File(filePath);


            System.out.println("Please, enter the search word: ");
            searchWord = userInput.nextLine();

            System.out.println("The word to replace the search word with: ");
            replaceWord = userInput.nextLine();


            System.out.println("Please, enter the source file?");
            filePath = userInput.nextLine();
            f = new File(filePath);

            if (f.isDirectory()) {
                System.out.println("type: directory");
            } else if (f.isFile()) {
                System.out.println("type: file");
            } else {
                System.out.println(f.getAbsolutePath() + "does not exist. ");
            }


            System.out.println("What is the destination file?");
            String destinationFile = userInput.nextLine();
            File outputFile = new File(destinationFile);

            try {
                outputFile.createNewFile();
            } catch (IOException e) {
                e.getMessage();
            }
            PrintWriter writer = null;

            if (outputFile.exists()) {
                try {
                    writer = new PrintWriter(outputFile.getAbsoluteFile());
                } catch (FileNotFoundException e) {
                    e.getMessage();
                }
                if (f.exists()) {
                    try (Scanner inputScanner = new Scanner(f.getAbsoluteFile())) {
                        while (inputScanner.hasNextLine()) {
                            String lineInput = inputScanner.nextLine();
                            lineInput = lineInput.replaceAll(searchWord, replaceWord);

                            if (inputScanner.hasNextLine()) {
                                writer.println(lineInput);
                            } else {
                                writer.println(lineInput);
                            }
                        }
                    }

                catch(FileNotFoundException e){
                    System.out.println("hmm, that's weird. Something is off");
                    System.out.println(e.getMessage());
                    exit(-1);
                }

            }
            writer.flush();
            writer.close();

        }
    }
}

