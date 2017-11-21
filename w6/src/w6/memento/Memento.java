/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w6.memento;

/**
 *
 * @author marin
 */


import java.util.LinkedList;

public class Memento {
	private LinkedList<Integer> memento;
	
	public Memento(LinkedList<Integer> mementoList) {
		memento = mementoList;
	}

	public LinkedList<Integer> getMemento() {
		return memento;
	}
	
	
	
}
