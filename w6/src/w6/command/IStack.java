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
interface IStack {
    void push(int i); //correct
    void pop(); //correct
    int top(); //correct
    boolean empty(); //correct
    void undo();//correct
    void redo();
}
