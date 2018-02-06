/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w11;

import java.awt.*;

/**
 *
 * @author marina
 */

class Fly {
    
    private final double k = 0.01;
    private double x, y; // fly's position
    private double vx, vy; // fly's velocity

    private int time=0;

    private State normal;
    private State dizzy;
    private State freezing;
    private State flyState;
        
    public Fly() {
        
        normal = new NormalState(this);
        dizzy  = new DizzyState(this);
        freezing = new FreezingState(this);
                
        x = Math.random();
        y = Math.random();
        vx = k*(Math.random() - Math.random());
        vy = k*(Math.random() - Math.random());
        flyState = normal;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public State getNormal() {
        return normal;
    }

    public void setNormal(State normal) {
        this.normal = normal;
    }

    public State getDizzy() {
        return dizzy;
    }

    public void setDizzy(State dizzy) {
        this.dizzy = dizzy;
    }

    public State getFreezing() {
        return freezing;
    }

    public void setFreezing(State freezing) {
        this.freezing = freezing;
    }
        
    public State getNormalState() {
        return normal;
    }

    public State getDizzyState() {
        return dizzy;
    }

    public State getFreezingState() {
        return freezing;
    }
        
    public int getTime() {
        return time;
    }
    
    public void setTime(int time) {
            this.time = time;
    }
    public void setFlyState(State newFlyState) {
        flyState = newFlyState;
    }


    public void draw(Graphics g) {
        /*if (time>0) 
                g.setColor(Color.red);
        else
                g.setColor(Color.black);*/
        Rectangle rc = g.getClipBounds();
        int a = (int)(x*rc.getWidth()),
                b = (int)(y*rc.getHeight());
        g.fillOval(a, b, 5, 5);
    }
    public void move() {    
        /*if (time > 0) {
                x += vx/2;
                y += vy/2;	
                -- time;
        } else {
                x += vx;
                y += vy;
        }*/
        if(x<0) { x = -x; vx = -vx; time+=100; }
        if(x>1) { x = 2-x;vx = -vx; time+=100;}
        if(y<0) { y = -y; vy = -vy; time+=100;}
        if(y>1) { y = 2-y;vy = -vy; time+=100;}
        
        flyState.move();
    }
}