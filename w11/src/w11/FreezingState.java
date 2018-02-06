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

public class FreezingState implements State {
    private Fly f;

    public FreezingState(Fly f) {
        this.f = f;
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
    }

    @Override
    public void move() {
        int time = f.getTime();
        --time;
        f.setX(f.getX());
        f.setY(f.getY());
        f.setTime(time);
        System.out.println("FREEZING");
        
        if (time <= 0)
            f.setFlyState(f.getNormalState());
    }
    
}
