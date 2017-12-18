/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w10;

/**
 *
 * @author marina
 */

public class Move implements VisitorMethod{
    
    public double x, y;

    public Move(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public Object call(Circle c) {
        c.x = x;
        c.y = y; 
        System.out.println("x:" + c.x + " y:" + c.y);
        return null;
    }

    @Override
    public Object call(Triangule t) {
        t.x = x;
        t.y = y; 
        System.out.println("x:" + t.x + " y:" + t.y);
        return null;
    }

    @Override
    public Object call(Square s) {
        s.x = x;
        s.y = y; 
        System.out.println("x:" + s.x + " y:" + s.y);
        return null;    
    }
}
