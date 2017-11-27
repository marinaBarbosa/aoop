/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w6.command;

/**
 *
 * @author marina
 */
public class PushCommand implements Command{
    private int i;
    private Stack s;
            
    PushCommand(int i,Stack s){
        this.i = i;
        this.s = s;
    }
    
    @Override
    public void undo() {
        s.data.removeLast();
    }
    
    @Override
    public void redo() {
        s.data.addLast(i);
    }
}
