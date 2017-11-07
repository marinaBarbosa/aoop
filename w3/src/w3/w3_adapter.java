/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author marin
 */
public class w3_adapter {

    public static void main(String[] args) {

        final Base base = new Base();

        final JFrame frame = new JFrame("Exercise 4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JSplitPane splitPane = new JSplitPane();

        final JList list = new JList(base);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBorder(BorderFactory.createTitledBorder(" Tables: "));
        splitPane.setLeftComponent(scrollPane);
        
        final DataModel dm = new DataModel();
        JTable table = new JTable();
        scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder(" Content: "));
        splitPane.setRightComponent(scrollPane);

        frame.getContentPane().add(splitPane);

        JMenuBar bar = new JMenuBar();
        JButton add = new JButton("Add a table");
        JButton del = new JButton("Remove the table");
        bar.add(add);
        bar.add(del);

        frame.setJMenuBar(bar);

        frame.setSize(600, 450);
        frame.setVisible(true);

        splitPane.setDividerLocation(0.5);

        add.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String value = JOptionPane.showInputDialog(frame,
                        "Give the table size",
                        "Add",
                        JOptionPane.INFORMATION_MESSAGE);
                try{
                    int size = Integer.parseInt(value);
                    base.add(new RealData(size));
                } catch(Exception ex) { };
            }
        });
        del.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int idx = list.getSelectedIndex();
                try{
                    base.remove(idx);
                } catch(Exception ex) { };
            }
        });

        // change on the list will refresh the table
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int idx = list.getSelectedIndex();
                if (idx >= 0) {
                    /* ... */
                }
            }
        });
    }
}
