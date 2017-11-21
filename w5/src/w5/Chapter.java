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

import java.util.ArrayList;

public class Chapter extends Unit{
    
    ArrayList<Paragraph> pr = new ArrayList<>();
    
    public Chapter() {
       super(); 
    }
  
    @Override
    public void addParagraph(Unit paragraph) {
        pr.add((Paragraph) paragraph);
    }

    public void print(Boolean x) {
        String s = "";
        for (int i=0; i< pr.size(); i++ ) {    
            pr.get(i).print((Boolean)null);
            System.out.println("\n");
        }
    }
}
