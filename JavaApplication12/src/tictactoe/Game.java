package tictactoe;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import tictactoe.Board;
import tictactoe.DefensiveStrategy;
import tictactoe.Move;
import tictactoe.MyButton;
import tictactoe.OffensiveStrategy;
import tictactoe.RandomStrategy;
import tictactoe.Strategy;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;


class Game extends JFrame {

	private Board board;
	private Strategy str = new DefensiveStrategy();
	MyButton buttons[][];
	JButton randomStrButton = new JButton();
	JButton offensiveStrButton = new JButton();
	JButton defensiveStrButton = new JButton();
	JTextArea currentStr = new JTextArea();

	public class MyActionListener implements ActionListener {


		private void check() {
			int ckeck = board.checkWon();
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

		@Override
		public void actionPerformed(ActionEvent evt) {


			MyButton bt = (MyButton)(evt.getSource());
			bt.setText(" O ");
			board.set(bt.row, bt.col, Board.PLAYER);
			bt.removeActionListener(this);


			if(randomStrButton == (JButton)evt.getSource())
				System.out.println("funciono!s");

			currentStr.append(str.getClass().toString() + "\n");

			System.out.println(str.getClass());
			check();
			Move m = str.calculateNextMove(board);
			bt = buttons[m.row][m.col];
			bt.setText(" X ");
			bt.removeActionListener(this);
			board.set(bt.row, bt.col, Board.COMPUTER);
			check();

		}



	}



	public Game(Board b) {
		board = b;
		int s = board.getSize();
		buttons = new MyButton[s][s];
		JPanel leftNav = new JPanel();
		ActionListener al = new MyActionListener();
		leftNav.setLayout(new GridLayout(s,s));


		JSplitPane pane = new JSplitPane();
		JSplitPane paneSecondary = new JSplitPane();

		JPanel rightNav = new JPanel();
		JButton randomStrButton = new JButton();
		randomStrButton.setText("Random Strategy");
		rightNav.add(randomStrButton);
		JButton offensiveStrButton = new JButton();
		offensiveStrButton.setText("Offensive Strategy");
		rightNav.add(offensiveStrButton);
		JButton defensiveStrButton = new JButton();
		defensiveStrButton.setText("Defensive Strategy");
		rightNav.add(defensiveStrButton);



		randomStrButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedRandom();
			}
		});
		offensiveStrButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedOffensive();
			}
		});
		defensiveStrButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedDefensive();
			}
		});


		for (int i = 0; i < s ; ++i) 
			for (int j = 0; j < s; ++j) {
				buttons[i][j] = new MyButton("   ", i, j);
				buttons[i][j].addActionListener(al);
				leftNav.add(buttons[i][j]);
			}

		pane.setLeftComponent(leftNav);
		pane.setRightComponent(paneSecondary);
		paneSecondary.setOrientation(JSplitPane.VERTICAL_SPLIT);
		paneSecondary.setLeftComponent(rightNav);
		currentStr.setEditable(false);
		paneSecondary.setRightComponent(currentStr);


		pane.setDividerLocation(1200);
		add(pane);


	}

	protected void selectedRandom() {
		setStr( new RandomStrategy());
		currentStr.append(str.toString());
	}
	protected void selectedDefensive() {
		setStr (new DefensiveStrategy());
		currentStr.append(str.toString());		
	}
	protected void selectedOffensive() {
		setStr( new OffensiveStrategy());
		currentStr.append(str.toString());		
	}

	public void setStr(Strategy str) {
		this.str = str;
	}

	public Strategy getStr() {
		return str;
	}
}