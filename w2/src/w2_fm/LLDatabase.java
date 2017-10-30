/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w2_fm;

import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author marina
 */
class LLDatabase extends FMDatabase{
    public LLDatabase() {
        super();
    }
    
    protected List<Integer> createList() {
        return new LinkedList<Integer>();
    }
}
