/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w6.command;

/**
 *
 * @author marina
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.*;

public class StackUndoRedo extends JFrame{ 
    private IStack stack=new Stack();
    JTextField message = new JTextField("<empty>");
    public static void main(String[] args) {
        new StackUndoRedo().setVisible(true);
    }
StackUndoRedo() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(new GridLayout(2,3));
    JButton b=new JButton("Push"); add(b);

    b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            String s=JOptionPane.showInputDialog(null, "Give a number: ");
            if (s==null) return;
            int i=0;
            try { 
                i=Integer.parseInt(s); 
                stack.push(i); 
                refresh();
            }
            catch (Exception ex) { 
                JOptionPane.showMessageDialog(null, "Bad number"); 
            }
        }
    });
    
    b=new JButton("Undo"); add(b);
    b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            stack.undo(); 
            refresh();
        }
    });
    add(new JLabel("Top of the stack: "));
    b=new JButton("Pop"); add(b);
    b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (stack.empty())
                JOptionPane.showMessageDialog(null, "Stack empty !");
            else { 
                stack.pop(); 
                refresh();
            }
        }
    });
    b=new JButton("Redo"); add(b);
    b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            stack.redo(); 
            refresh();
        }
    });
    add(message);
    pack(); 
    }
    private void refresh(){
        if (stack.empty()) message.setText("<empty>");
        else message.setText(stack.top()+"");
    }
}