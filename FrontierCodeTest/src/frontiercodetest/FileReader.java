/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontiercodetest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Read in a file
 * @author Shawn
 */
public class FileReader {
    
    public void openFile(String filePath, String fileName) throws FileNotFoundException
    {
        String FQPath;
        
        FQPath = filePath+File.separator+fileName;
        System.out.println("Opening: "+FQPath);
        File file = new File(FQPath);
        Scanner read = new Scanner(file);
        read.useDelimiter("->|"+System.getProperty("line.separator"));
        String before, after;
        ArrayList<ClothingItem> clothingOrder = new ArrayList<ClothingItem>();
        
        while(read.hasNext())
        {
            before = read.next();
            after = read.next();
            System.out.println("before:"+before+" after:"+after);            
            
            //Do work on the items
            //Check if before exists in the list
            ClothingItem tempItem = new ClothingItem();
            tempItem = tempItem.search(clothingOrder, before);            
            if(tempItem == null)
            {
               ClothingItem newItem = new ClothingItem(before);
               //tempItem.comesBefore(after);
               clothingOrder.add(newItem);
            }
            else
            {
              //add the before relationship    
               tempItem.addBefore(after);
                       
            }
            //Check if after exists in the list
            tempItem = new ClothingItem();
            tempItem = tempItem.search(clothingOrder, after);
            if(tempItem == null)
            {
                ClothingItem newItem = new ClothingItem(after);
               //tempItem.comesBefore(after);
               clothingOrder.add(newItem);
            }
            else 
            {
               //add the after relationship
                tempItem.addAfter(before);
            }            
        }
        read.close();
        for(ClothingItem i : clothingOrder){
            System.out.println(i.getName());
        }
    }

}
