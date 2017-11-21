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
interface Command {
    void undo();
    void redo();
    int getValue();
}