/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w8.strategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author marina
 */

class Game extends JFrame {
    private Board board;
    private Strategy str=new RandomStrategy();
  
    MyButton buttons[][];
    
    private class MyActionListener implements ActionListener {
	private void check() {
	    int ckeck=board.checkWon();
	    switch (ckeck) {
	        case Board.COMPUTER:
    	    	    JOptionPane.showMessageDialog(null, "Computer won !");
		    System.exit(0);
		    break; 
		case Board.PLAYER:
    		    JOptionPane.showMessageDialog(null, "You won !");
		    System.exit(0);
		    break; 
		case Board.BLOCKED:
    		    JOptionPane.showMessageDialog(null, "Nobody won !");
		    System.exit(0);
		    break; 
		}
	    }
	public void actionPerformed(ActionEvent evt) {
	    MyButton bt=(MyButton)(evt.getSource());
	    bt.setText(" O ");
	    board.set(bt.row, bt.col, Board.PLAYER);
	    bt.removeActionListener(this);
	    check();
            int strategy = ThreadLocalRandom.current().nextInt(1, 4);
                switch (strategy) {
                    case 1:
                        setStrategy(new RandomStrategy());
                        Move m=str.calculateNextMove(board);
                        bt=buttons[m.row][m.col];
                        System.out.println(str.toString());
                        break;
                    case 2:
                        setStrategy(new Offensive());
                        Move mo=str.calculateNextMove(board);
                        bt=buttons[mo.row][mo.col];
                        System.out.println(str.toString());
                        break;
                    case 3:
                        setStrategy(new Defensive());
                        Move md=str.calculateNextMove(board);
                        bt=buttons[md.row][md.col];
                        System.out.println(str.toString());
                        break;                  
                }	    
	    bt.setText(" X ");
	    bt.removeActionListener(this);
	    board.set(bt.row, bt.col, Board.COMPUTER);
	    check();
	}
    }

    public Game(Board b) {
	board=b;
	int s=board.getSize();
	buttons=new MyButton[s][s];
	ActionListener al=new MyActionListener();
	getContentPane().setLayout(new GridLayout(s,s));
	for (int i=0;i<s;++i) 
	    for (int j=0;j<s;++j) {
		buttons[i][j]=new MyButton("   ", i, j);
		buttons[i][j].addActionListener(al);
		add(buttons[i][j]);
	    }
	pack();
    }
    public void setStrategy(Strategy strategy){
        this.str = strategy;
    }
}