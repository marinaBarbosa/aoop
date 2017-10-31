/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w2_prototype;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author marin
 */
public class W2_prototype {
    public static void main(String[] args) {
        
        FMDatabase al = new FMDatabase(new ArrayList<Integer>());
        al.put(1, 5);
        System.out.println(al.contains(1,5));
        al.remove(1, 5);
        System.out.println(al.contains(1,5));
        
        al.flag(new LinkedList<Integer>());

        FMDatabase ll = new FMDatabase(new LinkedList<Integer>());
        ll.put(1, 5);
        System.out.println(ll.contains(1,5));
        ll.remove(1, 5);

    }
}
