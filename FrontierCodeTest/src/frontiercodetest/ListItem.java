/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontiercodetest;

import java.util.ArrayList;
import java.util.List;

/**
 * Object to hold data on each item from the file.
 *
 * @author Shawn
 */
public class ListItem {

    /**
     * Between the before and after can determine what depth the item is in the
     * process name - name of the object comesBefore - what items are before
     * this object based on the order in the file comesAfter - what items are
     * after this object based on the order in the file
     */
    private String name;
    public List<String> comesBefore = new ArrayList<>();
    public List<String> comesAfter = new ArrayList<>();

    // Constructors
    public ListItem() {
    }

    public ListItem(String name) {
        this.name = name;
    }

    //gets & sets
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getComesBefore() {
        return comesBefore;
    }

    public List<String> getComesAfter() {
        return comesAfter;
    }

    //Additional methods
    /**
     * Search the list for the specific object name and return the item
     *
     * @param list the list to search through
     * @param name object name to look for
     * @return the item object if found or null if it doesn't exist
     */
    public ListItem search(ArrayList<ListItem> list, String name) {
        for (ListItem item : list) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Add item to the before list
     *
     * @param name
     */
    public void addBefore(String name) {
        comesBefore.add(name);
    }

    /**
     * Add item to the after list
     *
     * @param name
     */
    public void addAfter(String name) {
        comesAfter.add(name);
    }

}
