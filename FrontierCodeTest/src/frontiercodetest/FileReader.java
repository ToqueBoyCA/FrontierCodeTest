/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontiercodetest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Read in a file from disk. Setup objects based on the ordering of the items.
 *
 * @author Shawn Smith
 */
public class FileReader {

    /**
     *
     * @param FQName - Fully Qualified Name - should be compatible across OS
     * (check on Mac)
     * @throws FileNotFoundException
     */
    public void openFile(String FQName) throws FileNotFoundException {
        System.out.println("Opening: " + FQName);
        File file = new File(FQName);
        ArrayList<ListItem> itemOrder;
        try (Scanner read = new Scanner(file)) {
            read.useDelimiter("->|" + System.getProperty("line.separator"));
            String before, after;
            itemOrder = new ArrayList<>();
            while (read.hasNext()) {
                before = read.next();
                after = read.next();
                //Issue with inputs from Win to OSX›
                after = after.replaceAll("\\r","");
                //debugging                
                //System.out.println("before:"+before+" after:"+after);

                //Do work on the items
                //Check if before exists in the list
                ListItem tempItem = new ListItem();
                tempItem = tempItem.search(itemOrder, before);
                if (tempItem == null) {
                    ListItem newItem = new ListItem(before);
                    newItem.addBefore(after);
                    itemOrder.add(newItem);
                } else {
                    //add the before relationship
                    tempItem.addBefore(after);

                }
                //Check if after exists in the list
                tempItem = new ListItem();
                tempItem = tempItem.search(itemOrder, after);
                if (tempItem == null) {
                    ListItem newItem = new ListItem(after);
                    newItem.addAfter(before);
                    itemOrder.add(newItem);
                } else {
                    //add the after relationship
                    tempItem.addAfter(before);
                }
            }
        }
        //debugging system out
        
//         for(ListItem i : itemOrder){
//         System.out.println(i.getName()+"\nAfter:"+i.getComesAfter().toString()+"\nBefore:"+i.getComesBefore().toString()+"\n");
//         }
        
        OrderedPrint newPrint = new OrderedPrint();
        newPrint.printListingOrder(itemOrder);

    }

}
