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

public class Character extends Unit{

    char c;
	
    Character(char c){
        this.c = c;	
    }    
	
    public void print() {	
        System.out.printf("%c",c);	
    }
		
}
