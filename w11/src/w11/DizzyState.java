/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w11;

import java.awt.Graphics;

/**
 *
 * @author marina
 */
import java.awt.Color;

public class DizzyState implements State {

    private Fly f;

    public DizzyState(Fly f) {
        this.f = f;
    }
 
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.red);
    }

    @Override
    public void move() {
        double x =  f.getX();
        double y = f.getY();
        double vx = f.getVx();
        double vy = f.getVy();
        int time = f.getTime();
        
        x += vx/2;
        y += vy/2;	
        --time;
        
        f.setX(x);
        f.setTime(time);
        f.setY(y);
        
        System.out.println("DIZZY");

        if(time <= 0) {
            time += 100;
            f.setTime(time);
            f.setFlyState(f.getFreezingState());
        }
    }
    
}
