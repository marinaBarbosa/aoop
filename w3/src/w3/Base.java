/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w3;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author marin
 */
// database - collection of Data
class Base extends AbstractListModel{
    
    private ArrayList<Data> ar = new ArrayList<Data>();

    public void add(Data tab){
        ar.add(tab);
        
    }

    public void remove(int idx){
        ar.remove(idx);
    }

    public int getSize() {
        /* ... */
        return ar.size();
    }

    public Object getElementAt(int index) {
        /* ... */
        return ar;
    }
}
