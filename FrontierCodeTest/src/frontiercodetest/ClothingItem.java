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
public class ClothingItem {
    
    public ClothingItem(){}

    public ClothingItem(String name) {
        this.name = name;
    }
    private int order;
    private String name;
    public List<String> comesBefore = new ArrayList<String>();
    public List<String> comesAfter = new ArrayList<String>();

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setComesAfter(){
        
    }
    public ClothingItem search(ArrayList<ClothingItem> list, String name)
    {
        for(ClothingItem item : list){
            if(item.getName().equalsIgnoreCase(name)) {return item;}
    }
        return null;
    }
    public void addBefore(String name)
    {
       comesBefore.add(name);
    }
    public void addAfter(String name)
    {
       comesAfter.add(name);
    }
    }
