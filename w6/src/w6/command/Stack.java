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
    //Command e;
    LinkedList <Integer> data = new LinkedList();
    LinkedList <Command> undoCommandList = new LinkedList();
    LinkedList <Command> redoCommandList = new LinkedList();
    
    @Override
    public void push(int i) {
        data.add(i);
        undoCommandList.add(new PushCommand(top(), this));
        System.out.println(top());
    }

    @Override
    public void pop() {
        try{
            undoCommandList.add(new PopCommand(top(),this));
            data.removeLast();
            System.out.println(top());
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
    public void undo(){ //need save the operations - if make redo operation
        
        try{
            Command h1 = undoCommandList.getLast();
            undoCommandList.removeLast();
        
            Command h2 = h1;
		
            if (h1.getClass().getName().equals("commandGUI.PushCommand")) {
                h2 = new PushCommand(h2.getValue(),this);
            }
            else {
                h2 = new PopCommand(h2.getValue(),this);
            }
            redoCommandList.addLast(h1);
            h2.undo();// - Add always the first on the redo list...
        }
        catch (NoSuchElementException e){
           System.out.println("EMPTY STACK -> UNDO");
        }
    }
    

    @Override
    public void redo() {
        try {
            
            Command h1 = redoCommandList.getLast();
            redoCommandList.removeLast();

            Command h2 = h1;

            if (h1.getClass().getName().equals("commandGUI.PushCommand")) {
                h2 = new PushCommand(h1.getValue(),this);
            }
            else {
                h2 = new PopCommand(h1.getValue(),this);
            }
            undoCommandList.addLast(h2);
            h1.redo();
        }
        catch (NoSuchElementException e){
           System.out.println("EMPTY STACK -> UNDO");
        }
    }
    
}



