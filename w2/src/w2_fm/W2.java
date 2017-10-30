/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w2_fm;

/**
 *
 * @author marin
 */
public class W2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        FMDatabase al = new ALDatabase();
        System.out.println(al.contains(1, 3));
        al.put(1, 3);
        al.put(1, 3);
        System.out.println(al.contains(1, 3));
        al.remove(1, 3);
        
        FMDatabase ll = new LLDatabase();
        System.out.println(ll.contains(1, 3));
        ll.put(1, 3);
    }
}
