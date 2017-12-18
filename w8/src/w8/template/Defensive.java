/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w8.template;

import java.util.Random;

/**
 *
 * @author marina
 */

public class Defensive extends Game{
    
    public Defensive(Board b) {
        super(b);
    }

    @Override
    Move calculateNextMove(Board b) {
       	int size=b.getSize();
	Random r=new Random(System.currentTimeMillis());
	int[][] visited=new int[size][size];
	int square=size*size;
	while (square>0) {
	    int hit=r.nextInt(square);
	    for (int i=0; i<size; ++i)
		for (int j=0; j<size; ++j) {
		    if (b.get(i,j) != Board.FREE) continue;
		-- hit;
		if (hit<0) return new Move(i, j);
	    }
	    --square;
	}
	return null;
    }
    
}
