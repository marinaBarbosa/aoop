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
import w7.Iterator;

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

    // intead - add the following method to get the iterator
    @Override
    public Iterator<Tile> iterator(){
        return new NameIterator();
    }

    private class NameIterator implements Iterator<Tile> {	
        
    private int pX;
    private int pY;

    @Override
    public void setY(int pY) {
        this.pY = pY;
    }
@Override
    public void setX(int pX) {
        this.pX = pX;
    }


    @Override
    public boolean hasNext() {
        if (pY !=  matrix.length) {
            if(pY < matrix.length && pX < matrix[pY].length ) {
                return true;
            }
        return false;
        }
    return false;
    }

    @Override
    public Tile next() {
        Tile t = null;
        if (hasNext()) {
            if(pX < matrix[pY].length-1) {
                pX++;
            }
            else {
                pX = 0;
                pY++;
            }
            if(pY != matrix.length)
                t = matrix[pY][pX];
                return t;
            }
        return t;
        }
    }
}
