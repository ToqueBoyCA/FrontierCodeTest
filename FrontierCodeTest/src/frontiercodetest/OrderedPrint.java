/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontiercodetest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shawn
 */
public class OrderedPrint {
    
    public void printClothingOrder(ArrayList<ClothingItem> list)
    {
        ArrayList<String> list1 = new ArrayList<String>();
        //find the first items - anything with an after count of 0
        for(ClothingItem temp : list){
            if(temp.getComesAfter().size() == 0)
            {
                list1.add(temp.getName());
            }
        }
        java.util.Collections.sort(list1);
        printEachItem(list1);
    }
    public void printEachItem(ArrayList<String> l)
    {
        //need to add the commas in multiline
        String printString = String.join(",", l);
        System.out.println(printString);        
    }
}
