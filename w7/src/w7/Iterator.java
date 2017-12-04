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
public interface Iterator <Tile>{
    
   public boolean hasNext();
   public Tile next();
   public void setY(int pY);
   public void setX(int pX);
}
