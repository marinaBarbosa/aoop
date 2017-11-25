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
import java.util.NoSuchElementException;

public class Stack implements IStack{
    
    private LinkedList <Integer> data;
    private LinkedList <Memento> undoMementoList;
    private LinkedList <Memento> redoMementoList;
    
    public Stack() {
        data = new LinkedList<Integer>();
        undoMementoList = new LinkedList<Memento>();
        redoMementoList = new LinkedList<Memento>();
    }
    
    public Memento saveStateToMemento() {
        return new Memento(data);
    }
        
    public void getStateFromMemento(Memento memento) {
        if (memento.getState() == null) {
            return;
        }
    data = memento.getState();
    }
    
    @Override
    public void push(int i) { 
        undoMementoList.addLast(saveStateToMemento());
        data.addLast(i);
    }
    
    @Override
    public void pop() {
        undoMementoList.addLast(saveStateToMemento());
        data.removeLast();
    }
    
    @Override
    public void undo() {
        try{
            redoMementoList.addLast(saveStateToMemento());
            getStateFromMemento(undoMementoList.getLast());
            undoMementoList.removeLast();
        }
        catch (NoSuchElementException e){
           System.out.println("EMPTY STACK -> UNDO");
        }
    }

    @Override
    public void redo() {
        try{
            undoMementoList.addLast(saveStateToMemento());
            getStateFromMemento(redoMementoList.getLast());
            redoMementoList.removeLast();
        }
        catch (NoSuchElementException e){
           System.out.println("EMPTY STACK -> REDO");
        }
    }
    
    @Override
    public boolean empty() {
        return data.isEmpty();
    }
    
    @Override
    public int top() {
        return data.getLast();
    }
}
