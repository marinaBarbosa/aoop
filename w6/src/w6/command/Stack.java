/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w6.command;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import javax.swing.JFrame;

/**
 *
 * @author marina
 */

public class Stack implements IStack {
    LinkedList <Integer> data = new LinkedList();
    LinkedList <Command> undoCommandList = new LinkedList();
    LinkedList <Command> redoCommandList = new LinkedList();
    
    @Override
    public void push(int i) {
        data.add(i);
        undoCommandList.add(new PushCommand(top(), this));
    }

    @Override
    public void pop() {
        try{
            undoCommandList.add(new PopCommand(top(),this));
            data.removeLast();
        }
        catch (NoSuchElementException e){
           System.out.println("EMPTY STACK -> POP");
        }
    }

    @Override
    public int top() {
        return data.getLast();
    }

    @Override
    public boolean empty() {
        if (data.isEmpty())
            return true;
        return false;
    }

    @Override
    public void undo(){       
        try{
            Command h1 = undoCommandList.getLast();
            h1.undo();
            redoCommandList.addLast(h1);
            undoCommandList.removeLast();          
        }
        catch (NoSuchElementException e){
           System.out.println("EMPTY STACK -> UNDO");
        }
    }
    
    @Override
    public void redo() {
        try {
            Command h1 = redoCommandList.getLast();
            h1.redo();
            undoCommandList.addLast(h1);
            redoCommandList.removeLast();
        }
        catch (NoSuchElementException e){
           System.out.println("EMPTY STACK -> UNDO");
        }
    }
}



