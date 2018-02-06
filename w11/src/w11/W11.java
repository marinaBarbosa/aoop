/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w11;

import javax.swing.*;

/**
 *
 * @author marina
 */
public class W11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("Flies");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlyStates fs = new FlyStates();
        frame.getContentPane().add(fs);
        frame.pack();
        frame.setVisible(true);
        new Thread(fs).start();
    }
    
}
