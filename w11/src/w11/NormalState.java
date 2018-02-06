/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w11;


/**
 *
 * @author marina
 */

import java.awt.Color;
import java.awt.Graphics;

public class NormalState implements State {
    private Fly f;

    public NormalState(Fly f) {
        this.f = f;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
    }

    @Override
    public void move() {
        
        double x =  f.getX();
        double y = f.getY();
        double vx = f.getVx();
        double vy = f.getVy();

        x += vx;
        y += vy;
        f.setX(x);
        f.setY(y);

        System.out.println("NORMAL");

        if(f.getTime() > 0)
            f.setFlyState(f.getDizzyState());
        }
}
