/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w7;

/**
 *
 * @author marina
 */
//tile matrix

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

class Board extends JPanel implements Container{

    private Tile[][] matrix;
    private int tilesize;
    // higlighted (with mouse) tile 
    private int hx = -1, hy = -1;

    // matrix initialization
    public Board(int cols, int rows, int tilesize) {
        this.setPreferredSize(new Dimension(cols * tilesize, rows * tilesize));
        this.tilesize = tilesize;
        matrix = new Tile[rows][cols];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                matrix[i][j] = new Tile();
            }
        }
    }

    // matrix drawing (including the highlighted tile)
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (i == hy && j == hx) {
                    g.setColor(matrix[i][j].getColor().brighter());
                } else {
                    g.setColor(matrix[i][j].getColor());
                }
                g.fillRect(j * tilesize, i * tilesize + 1, tilesize - 1, tilesize - 1);
            }
        }
    }

    public void highlight(int x, int y) {
        hx = x;
        hy = y;
        repaint();
    }

    // 3 methods to remove in the final version
    /*public int getRows() {
        return matrix.length;
    }

    public int getCols() {
        return matrix[0].length;
    }

    public Tile getAt(int row, int col) {
        return matrix[row][col];
    }*/

    // intead - add the following method to get the iterator
    @Override
    public Iterator iterator(){
        return new NameIterator();
    }
    
   private class NameIterator implements Iterator {

      int x;
      int y;

      @Override
      public boolean hasNext() {
      
         if(x < matrix[y].length){
             x++;
             System.out.println(x);
           // return true;
         }
         return false;
      }

      @Override
      public Object next() {
      
         if(this.hasNext()){
            return names[index++];
         }
         return null;
      }		
   }
}
