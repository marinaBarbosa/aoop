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
public interface IStack {
	void push(int i);
	void pop();
	void undo();
	void redo();
	boolean empty();
	int top();
}