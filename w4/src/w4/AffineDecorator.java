/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w4;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

/**
 *
 * @author marin
 */

class AffineDecorator extends Decorator  {
    
    public static AffineTransform generateAT(double x, double y) {
        AffineTransform at = new AffineTransform();
        at.translate(x,y);
        return at;
    }
	
    private AffineTransform tr = null;

    public AffineDecorator(IPiece decorated) {
        super(decorated);
    }
    public AffineDecorator(IPiece decorated, AffineTransform tr){
            super(decorated);
            this.tr = tr;
    }
    @Override
    public void draw(Graphics2D g) {
        AffineTransform backup = g.getTransform();
        if(tr == null) {
            tr = new AffineTransform();
            tr.translate(Chessboard.ZEROX, Chessboard.ZEROY);
            tr.scale(Piece.TILESIZE, Piece.TILESIZE);
        }
        g.setTransform(tr);
        decorated.draw(g);
        g.setTransform(backup);
        
    }
    
    public int getX(){
        return decorated.getX();
    }
    public int getY(){ 
        return decorated.getY();
    }
    public void moveTo(int x, int y){
        decorated.moveTo(x,y);
    }
    public IPiece getDecorated(){ 
        return this.decorated; 
    }
}
