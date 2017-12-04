package tictactoe;

import java.awt.Point;
import java.util.Random;

public class DefensiveStrategy implements Strategy {

	@Override

	public Move calculateNextMove(Board b) {
		int size = b.size;
		int counter = 0;
		int win = b.getWin() - 1;
		int squareX = 0,squareY = 0;
		//Horizontal  left-right

		for(int i = 0; i < size; i++ ) {
			for(int j = 0; j < size; j++) {
				if(b.get(i, j) == b.PLAYER) {
					counter++;
					if(j - 1 >= 0 && b.get(i, j - 1) == b.FREE) {
						squareX = i;
						squareY = j - 1;
					}

				}else {
					counter = 0;
				}
				if (counter == win) {
					if(j + 1 < size && b.get(i, j + 1) == b.FREE)
						return new Move(i,j + 1);
				}
			}
		}
		//Horizontal right to left
		counter = 0;
		for(int i = 0; i < size; i++ ) {
			for(int j = size - 1; j > 0; j--) {
				if(b.get(i, j) == b.PLAYER) {
					counter++;
					if(j + 1 < size && b.get(i, j + 1) == b.FREE) {
						squareX = i;
						squareY = j + 1;
					}

				}else {
					counter = 0;
				}
				if (counter == win) {
					if(j - 1 >= 0 && b.get(i, j - 1) == b.FREE)
						return new Move(i,j - 1);
				}
			}
		}
		/*	if (b.get(squareX, squareY) == b.FREE) {
			return new Move(squareX,squareY);
		}*/
		//Vertical upper-down
		counter = 0;
		for(int i = 0; i < size; i++ ) {
			for(int j = 0; j < size; j++) {
				if(b.get(j, i) == b.PLAYER) {
					counter++;
					if(j - 1 >= 0 && b.get(j - 1, i) == b.FREE) {
						squareX = j - 1;
						squareY = i;
					}

				}else {
					counter = 0;
				}
				if (counter == win) {
					if(j + 1 < size && b.get(j + 1, i) == b.FREE)
						return new Move(j + 1,i);
				}
			}
		}
		//Vertical down-upper
		counter = 0;
		int i = 0;
		while (i < size) {
			for(int j = size - 1; j > 0; j--) {
				if(b.get(j, i) == b.PLAYER) {
					counter++;
					if(j + 1 < size && b.get(j + 1, i) == b.FREE) {
						squareX = j + 1;
						squareY = i;
					}

				}else {
					counter = 0;
				}
				if (counter == win) {
					if(j - 1 >= 0 && b.get(j - 1, i) == b.FREE)
						return new Move(j - 1,i);
				}
			}
			i++;
		}
		
		//principal diagonal left - right
		counter = 0;
		for(i = 0; i < size; i++) {
			if(b.get(i, i) == b.PLAYER) {
				counter++;
				if(i - 1 >= 0 && b.get(i - 1, i - 1) == b.FREE) {
					squareX = i - 1;
					squareY = i - 1;
				}
			}else {
				counter = 0;
			}
			if (counter == win) {
				if(i + 1 < size && b.get(i + 1, i + 1) == b.FREE)
					return new Move(i + 1,i + 1);
			}
		}
		//principal diagonal right - left
		counter = 0;
		for(i = size - 1;i > 0; i--) {
			if(b.get(i, i) == b.PLAYER) {
				counter++;
				if(i - 1 >= 0 && b.get(i - 1, i - 1) == b.FREE) {
					squareX = i - 1;
					squareY = i - 1;
				}
			}else {
				counter = 0;
			}
			if (counter == win) {
				if(i - 1 >= 0 && b.get(i - 1, i - 1) == b.FREE)
					return new Move(i - 1,i - 1);
			}

		}
		//first half -- False River upper -- left to right
		counter = 0;
		i = 0;
		int j = 0;
		for (int k = 0; k < size - 1; k++) {
			i = k;
			j = 0;
			while(i >= 0) {
				if(b.get(i, j) == b.PLAYER) {
					counter++;
					if(j - 1 >= 0  && i + 1 < size && b.get(i + 1, j - 1) == b.FREE) {
						squareX = i + i;
						squareY = j - 1;
					}
				}else {
					counter = 0;
				}
				if(counter == win) {
					if(i - 1 >= 0 && j + 1 < size && b.get(i - 1, j + 1) == b.FREE) {
						return new Move(i - 1,j + 1);
					}
				}
				i = i - 1;
				j = j + 1;
			}
		}

		//First Half -- False River upper --  right to left
		counter = 0;
		i = 0;
		j = 0;
		for (int k = size - 1; k > 0; k--) {
			i = k;
			j = 0;
			while(i >= 0) {
				if(b.get(i, j) == b.PLAYER) {
					counter++;
					if(j - 1 >= 0  && i + 1 < size && b.get(i + 1, j - 1) == b.FREE) {
						squareX = i + i;
						squareY = j - 1;
					}
				}else {
					counter = 0;
				}
				if(counter == win) {
					if(i - 1 >= 0 && j + 1 < size && b.get(i - 1, j + 1) == b.FREE) {
						return new Move(i - 1,j + 1);
					}
				}
				i = i - 1;
				j = j + 1;
			}
		}
		//Second  Half -- False River bottom --  left - right
		counter = 0;
		j = 0;
		i = 0;
		for (int k = 1;k < size; k++) {
			i = size - 1;
			j = k;
			while(j < size) {
				if(b.get(i, j) == b.PLAYER) {
					counter++;
					if(i + 1 < size && j - 1 >=0 && b.get(i + 1, j - 1) == b.FREE) {
						squareX = i + 1;
						squareY = j - 1;
					}
				}else {
					counter = 0;
				}
				if (counter == win) {
					if(i - 1 >= 0 && j + 1 < size && b.get(i - 1, j + 1) == b.FREE) {
						return new Move(i - 1, j + 1);
					}
				}

				i = i - 1;
				j = j + 1;
			}

		}
		//Second  Half -- False River bottom --  right - left
		counter = 0;
		j = 0;
		i = 0;
		for (int k = 1;k < size; k++) {
			i = size - 1;
			j = k;
			while(j < size) {
				if(b.get(j, i) == b.PLAYER) {
					counter++;
					if(i + 1 < size && j - 1 >= 0 && b.get(j - 1, i + 1) == b.FREE) {
						squareX = j - 1;
						squareY = i + 1;
					}
				}else {
					counter = 0;
				}
				if (counter == win) {
					if(i - 1 >= 0 && j + 1 < size && b.get(i - 1, j + 1) == b.FREE) {
						return new Move(j + 1, i - 1);
					}
				}

				i = i - 1;
				j = j + 1;
			}

		}
	
		//true river upper
		counter = 0;
		int l = 1;
		while (l < size) {
			for (i = l, j = 0; i < size;i++,j++) {

				if(b.get(i, j) == b.PLAYER) {
					counter++;
					if (i - 1 >= 0 && j - 1 >= 0 && b.get(i - 1, j - 1) == b.FREE) {

						squareX = i - 1;
						squareY = j - 1;
					}
				}else {
					counter = 0;
				}
				if (counter == win) {
					if(i + 1 < size && j + 1 < size && b.get(i + 1, j + 1) == b.FREE) {
						return new Move(i + 1,j + 1);
					}
				}


			}
			l++;
		}
		//True river bottom
		counter = 0;
		l = 1;
		while (l < size) {
			for (i = l, j = 0; i < size;i++,j++) {

				if(b.get(j, i) == b.PLAYER) {
					counter++;
					if (j - 1 > 0 && i - 1 > 0 && b.get(j - 1, i - 1) == b.FREE) {
						squareX = j - 1;
						squareY = i - 1;
					}
				}else {
					counter = 0;
				}
				if (counter == win) {
					if(j + 1 < size && i + 1 < size && b.get(j + 1, i + 1) == b.FREE) {
						return new Move(j + 1,i + 1);
					}
				}


			}
			l++;
		}





		if (b.get(squareX, squareY) == b.FREE) {
			System.out.println("square if");
			return new Move(squareX,squareY);

		}else {
			
			Random r = new Random(System.currentTimeMillis());
			int[][] visited = new int[size][size];
			int square = size * size;
			while (square > 0) {
				int hit = r.nextInt(square);
				for ( i = 0; i < size; ++i)
					for (j = 0; j < size; ++j) {
						if (b.get(i,j) != Board.FREE) continue;
						-- hit;
						if (hit < 0) return new Move(i, j);
					}
				--square;
			}
		}
		return null;


	}

}
