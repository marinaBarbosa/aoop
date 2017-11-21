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




public class Stack implements IStack {
	private LinkedList <Integer> data;
	private LinkedList <Memento> undoMementoList;
	private LinkedList <Memento> redoMementoList;


	public Stack() {
		data = new LinkedList<Integer>();
		undoMementoList = new LinkedList<Memento>();
		redoMementoList = new LinkedList<Memento>();
	}
	public void restoreMemento(Memento recover) {
		System.out.println(data.getLast());
		data = recover.getMemento();
		System.out.println(recover.getMemento());
	}
	public Memento storeInMemento() {
		return new Memento(data);
	}
	
	@Override
	public void push(int i) {
		Memento temp = this.storeInMemento();
		undoMementoList.addLast(temp);
		data.addLast(i);
		
	}

	@Override
	public void pop() {
		Memento temp = this.storeInMemento();
		undoMementoList.addLast(temp);
		data.removeLast();
		
	}

	@Override
	public void undo() {
		/*if (undoMementoList.isEmpty()) 
			return;*/
		
		restoreMemento(undoMementoList.getLast());
                //data.removeLast();
                undoMementoList.removeLast();
                data.removeLast();
		redoMementoList.addLast(undoMementoList.getLast());
                //data.removeLast();
		//undoMementoList.removeLast();
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		if (redoMementoList.isEmpty())
			return;
		Memento temp = redoMementoList.getLast();
		restoreMemento(temp);
                data.addFirst(undoMementoList.lastIndexOf(temp));
		undoMementoList.addLast(temp);
		redoMementoList.removeLast();
	}

	@Override
	public boolean empty() {

		return data.isEmpty();
	}

	@Override
	public int top() {
		// TODO Auto-generated method stub
		return data.getLast();
	}


}
