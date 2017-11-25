/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package w6.memento;

/**
 *
 * @author marina
 */

import java.util.LinkedList;

public class Memento {
    
    private LinkedList<Integer> state;

    public Memento(LinkedList<Integer> data) {
        state = (LinkedList<Integer>) data.clone();
    }

    public LinkedList<Integer> getState() {
        return state;
    }		
}
