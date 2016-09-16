/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontiercodetest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Shawn Smith
 */
public class Main {

    /**
     * Program entry - allows the user to define the filename to be used with
     * the program. TODO - Let the user set the path, use a swing component to
     * provide a GUI
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String fileName = null;
        String filePath = System.getProperty("user.dir") +File.separator+ "InputFiles";
        System.out.println("Please place the file in the following path:");
        System.out.println(filePath);
        do {
            System.out.println("Enter the file name (including extention):");
            Scanner userInput = new Scanner(System.in);
            fileName = userInput.next();
            String fullyQualifiedPath = filePath + File.separator + fileName;
            FileReader fReader = new FileReader();
            try {
                fReader.openFile(fullyQualifiedPath);

            } catch (FileNotFoundException ex) {
                System.out.println("ERROR: File Not found");
                System.out.println("Please check that the file is in the folder and try again");
                fileName = null;
            }
        } while (fileName == null);
    }

}
