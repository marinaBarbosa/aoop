/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w8.template;

/**
 *
 * @author marina
 */

import javax.swing.*;

class MyButton extends JButton {
    public int row, col; 
    public MyButton(String text, int r, int c) 
    { super(text); row=r; col=c; }
}
