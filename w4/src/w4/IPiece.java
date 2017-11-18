/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w4;

import java.awt.Graphics2D;

/**
 *
 * @author marina
 */

interface IPiece {
    public static final int TILESIZE = 32;
    void draw(Graphics2D g);
    int getX();
    int getY();
    void moveTo(int xx, int yy);
}
