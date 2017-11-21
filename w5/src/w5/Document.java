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

public class Document extends Unit{
    ArrayList<Chapter> ch = new ArrayList();
    
    public Document() {
        super();
    }
    
    public void addChapter(Unit chapter) {
        ch.add((Chapter)chapter);
    }
        
    public void print(Boolean x) {
        for(int i = 0;i < ch.size();i++){
            ch.get(i).print((Boolean)null);
        }
    }
}
