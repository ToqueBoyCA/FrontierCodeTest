/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontiercodetest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Deal with the ordering of the depths, sorting within those depths, adding the
 * separator then finally a print to screen
 *
 * @author Shawn
 */
public class OrderedPrint {

    /**
     *
     * @param list - The list to be looped over for printing
     */
    public void printListingOrder(ArrayList<ListItem> list) {
        ArrayList<String> list1 = new ArrayList<>();
        //find the first items - anything with an after count of 0
        for (Iterator<ListItem> iterator = list.iterator(); iterator.hasNext();) {
            ListItem ci = iterator.next();
            if (ci.getComesAfter().isEmpty()) {
                list1.add(ci.getName());
                iterator.remove();
            }
        }
        java.util.Collections.sort(list1);
        printEachItem(list1);
        getNextDepth(list, list1);
    }

    /**
     * Separate items at the same depth with a comma then print
     *
     * @param printList - List of items to be printed
     */
    private void printEachItem(ArrayList<String> printList) {
        //need to add the commas in multiline
        String printString = String.join(",", printList);
        System.out.println(printString);
    }

    /**
     * Remove the last depth from the comesAfter list in each object
     *
     * @param masterList - The list read in from file
     * @param lastDepth - The list of names from the last depth processed
     */
    private void getNextDepth(ArrayList<ListItem> masterList, ArrayList<String> lastDepth) {
        //ClothingItem tempItem = new ClothingItem();        
        for (ListItem item : masterList) {
            List<String> afterItems = item.getComesAfter();
            afterItems.removeAll(lastDepth);
        }
        if (masterList.size() > 0) {
            printListingOrder(masterList);
        }
    }
}
