/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w2_fm;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 *
 * @author marina
 */
abstract class FMDatabase {
    
    private Map <Integer,List<Integer>> data;
    protected abstract List<Integer> createList();
    public FMDatabase() {
        data = new HashMap<Integer, List<Integer>>();
    };
	
    //adding the pair (number1, number2) to the database
    public void put(int number1, int number2) {
        if (contains(number1,number2)) {
            if(data.containsKey(number1)) {
                data.get(number1).add(number2);
                System.out.println("Already exist the key! - put the number");
            }
        }
        else {
            data.put(number1, createList());
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