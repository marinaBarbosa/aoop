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

public class TicTacToe {
    public static void main (String[] args) {
	Board board=new Board(3,3);
        
        Game game = new RandomGame(board);
        System.out.println(game.toString()); 
        game = new Defensive(board);
        System.out.println(game.toString()); 
        game = new Offensive(board);
        System.out.println(game.toString());     
	game.setVisible(true);
	
    }
}
