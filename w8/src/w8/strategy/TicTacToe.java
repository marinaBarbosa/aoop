package w8.strategy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marina
 */

public class TicTacToe {
    public static void main (String[] args) {
	Board board=new Board(3,3);
        new Game(board).setVisible(true);	
    }
}
