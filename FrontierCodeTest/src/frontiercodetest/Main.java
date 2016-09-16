/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontiercodetest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shawn
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("The current working directory is:"+ System.getProperty("user.dir"));
        //System.out.print("Enter file location:");
        //System.in();
        //TODO allow user to change the file and path take into account the OS separators / or \
        //may be able to check the OS and raplace if inputted incorrectly
        
        FileReader fReader = new FileReader();
        try {
            fReader.openFile(System.getProperty("user.dir")+"\\InputFiles", "clothing.txt");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
