/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w6;

import java.util.LinkedList;

/**
 *
 * @author marina
 */
public class Stack implements IStack {
    private Command e;
    public LinkedList <Integer> data = new LinkedList();
    private LinkedList <Command> undoCommandList = new LinkedList();
    private LinkedList <Command> redoCommandList = new LinkedList();
    
    @Override
    public void push(int i) {
       data.add(i);
        System.out.println(data.getLast());
        //undoCommandList.addLast(new PopCommand(i,this));
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pop() {
        System.out.println(data.removeLast());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int top() {
        return data.getLast();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean empty() {
        if (data.isEmpty())
            return true;
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void undo() {
        //e.undo();
        //undoCommandList.add(data.getLast(),e);
        //System.out.println(undoCommandList.getFirst());
        Command h = redoCommandList.getLast();
        redoCommandList.removeLast();
        		undoCommandList.addLast(h);
		h.undo();
        //public LinkedList undoList = new LinkedList(Integer,Integer);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void redo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

