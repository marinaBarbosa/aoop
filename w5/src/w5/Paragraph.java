/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w5;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 * @author marin
 */
public class Paragraph extends Unit {
    
    ArrayList<Character> character = new ArrayList();
    private String paragraph;
    
    public Paragraph(String p1) {
        super();
        this.paragraph = p1;
        
    }
    
    public void addCharacter(Unit c) {
        Character characterf = (Character) c;
        character.add(characterf);  
    }
        
    public void print() {
        String s = "";
        for (int i=0; i<character.size();i++) {
            s = s + character.get(i).toString();
        }
        System.out.println(s);
    }
}
