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

public class Scale implements VisitorMethod {
    private double sizeScale;

    public Scale(double sizeScale) {
        this.sizeScale = sizeScale;
    }    

    @Override
    public Object call(Circle c) {
        double circleScale = c.length * sizeScale; 
        System.out.println("Scale - Circle: " + circleScale);
        return circleScale;
    }

    @Override
    public Object call(Triangule t) {
        double trianguleScale = t.length * sizeScale; 
        System.out.println("Scale - Triangule: " + trianguleScale);
        return trianguleScale;
    }

    @Override
    public Object call(Square s) {
        double squareScale = s.length * sizeScale; 
        System.out.println("Scale - Square: " + squareScale);
        return squareScale;
    }
}
