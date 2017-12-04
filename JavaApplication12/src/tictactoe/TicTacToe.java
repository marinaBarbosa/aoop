package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tictactoe.Board;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class TicTacToe{
	
	public static void main (String[] args) {
		int size,win;
		String name = null;
		final JFrame parent = new JFrame();
		JButton sizeButton = new JButton();
		
		
		JButton randomStrButton = new JButton();
		randomStrButton.setText("Random Strategy");
		JButton offensiveStrButton = new JButton();
		offensiveStrButton.setText("Offensive Strategy");
		JButton defensiveStrButton = new JButton();
		defensiveStrButton.setText("Defensive Strategy");
		
		parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sizeButton.setText("Set Size!");
		parent.add(sizeButton);
		
		
		parent.pack();
		parent.setLocation(150, 0);
		parent.setVisible(true);

		sizeButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				String name = null;
				int size,win;
				Board board = new Board(3,3);
				while(name == null || name.equals("")) {
					name = JOptionPane.showInputDialog(parent,
							"Enter Size of the board!", null);
					if(Integer.parseInt(name) < 3)
						name = null;

				}
				
				size =Integer.parseInt(name);
				name = null;
				while(name == null || name.equals("")) {
					name = JOptionPane.showInputDialog(parent,
							"Enter Win condition", null);
					if (Integer.parseInt(name) > size)
						name = null;

				}
				win = Integer.parseInt(name);
				board = new Board(size,win);
				Game ticTacToe = new Game(board);
				
				
				ticTacToe.setExtendedState(Frame.MAXIMIZED_BOTH);
				ticTacToe.setVisible(true);
			
				

			}
		});
		
		
	

	}
}

