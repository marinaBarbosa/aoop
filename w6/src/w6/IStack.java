    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w6;

/**
 *
 * @author marina
 */
interface IStack {
    void push(int i);
    void pop();
    int top();
    boolean empty();
    void undo();
    void redo();
}
