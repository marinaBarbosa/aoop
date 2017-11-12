/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w5;

/**
 *
 * @author marina
 */

public class Document {
    Chapter ch;
    public Document() {
        super();
    }
 
    public void addChapter(Chapter ch){
        this.ch = ch;
        
    }
    
    public void print() {
        System.out.println("DOCUMENT"+ ch);
    }
}
