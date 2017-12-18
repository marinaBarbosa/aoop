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

public abstract class Figure {
    double x;
    double y;
    double length = 1;

    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }
 
    public abstract Object call (VisitorMethod v);
}
