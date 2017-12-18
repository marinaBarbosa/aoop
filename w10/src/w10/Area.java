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

public class Area implements VisitorMethod{
                
    @Override
    public Object call(Circle c) {
        double areaCircle = Math.PI * (Math.pow(c.length, 2)); 
        System.out.println("Area - Circle: " + areaCircle);
        return areaCircle;
    
    }

    @Override
    public Object call(Triangule t) {
        double areaTriangule = 0.5*t.length*t.length; 
        System.out.println("Area - Triangule: " + areaTriangule);
        return areaTriangule;
    }

    @Override
    public Object call(Square s) {
        double areaSquare = s.length*s.length; 
        System.out.println("Area - Square: " + areaSquare);
        return areaSquare;  
    } 
}
