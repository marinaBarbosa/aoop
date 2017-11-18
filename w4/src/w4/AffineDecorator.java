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
 * @author marina
 */

class AffineDecorator extends Decorator  {
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
        AffineTransform b = g.getTransform();
        if(tr == null) {
            tr = new AffineTransform();
            tr.translate(Chessboard.ZEROX, Chessboard.ZEROY);
            tr.scale(Piece.TILESIZE, Piece.TILESIZE);
        }
        g.setTransform(tr);
        decorated.draw(g);  
        g.setTransform(b);
    }
    
    @Override
    public int getX(){
        return decorated.getX();
    }
    @Override
    public int getY(){ 
        return decorated.getY();
    }
    @Override
    public void moveTo(int x, int y){
        decorated.moveTo(x,y);
    }
    public IPiece getDecorated(){ 
        return this.decorated; 
    }
}
