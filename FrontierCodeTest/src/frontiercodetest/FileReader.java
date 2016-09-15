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
 * Read in a file
 * @author Shawn
 */
public class FileReader {
    
    public void openFile(String filePath, String fileName) throws FileNotFoundException
    {
        String FQPath ="";
        
        FQPath = filePath+File.separator+fileName;
        
        File file = new File(FQPath);
        Scanner read = new Scanner(file);
        read.useDelimiter("->");
        
        while(read.hasNext())
        {
            //Do work on the items
            System.out.print(read.nextLine());
        }
        
    }
    
}
