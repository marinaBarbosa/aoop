/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w1;

/**
 *
 * @author marina 
 */
public class W1 { //Teste Class

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        IConnection s1 = Database.getConnection();
        IConnection s2 = Database.getConnection();
        IConnection s3 = Database.getConnection();
        IConnection s4 = Database.getConnection();
        
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }
    
}
