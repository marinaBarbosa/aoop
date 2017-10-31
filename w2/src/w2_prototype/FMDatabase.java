/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w2_prototype;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author marina
 */
public class FMDatabase {
    
    private List<Integer> prototype;
    private HashMap <Integer,List<Integer>> data;
    //protected abstract List<Integer> createList();
    
    public FMDatabase() {
        //data = new HashMap<>();
        data = new HashMap<Integer,List<Integer>>();

    };
	
    public FMDatabase(List<Integer> l) {
        flag(l);
        data = new HashMap<>();
    }
	

    public void flag(List<Integer> l) {
        this.prototype = l;
    }
    
    
    public List<Integer> clonePrototype() {
        try {
            return (List)(prototype.getClass().getMethod("clone",new Class[0]).invoke(prototype, new Object[0]));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
    //adding the pair (number1, number2) to the database
    public void put(int number1, int number2) {
        if (contains(number1,number2)) {
            if(data.containsKey(number1)) {
                data.get(number1).add(number2);
                System.out.println("Already exist the key -> put the number");
            }
        }
        else {
            data.put(number1,clonePrototype());
            data.get(number1).add(number2);
            System.out.println("Add new number! + Key!");
        } 
    }
    
    //removing this pair
    public void remove(int number1, int number2) {
        if (contains(number1,number2) ) {
            data.get(number1).remove((Integer)number2);
            System.out.println("Remove");
        }
    }

    //checking if the given pair is present in the database (so returning "true") or not (returning "false")
    public boolean contains(int number1,int number2) {
        if(data.containsKey(number1)) {
            if(data.get(number1).contains(number2)) 
                return true;
            return false;
        }
        return false;
    }
}