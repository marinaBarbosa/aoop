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
public class Triangule extends Figure {

    public Triangule(double x, double y) {
        super(x,y);
        
    }

    @Override
    public Object call(VisitorMethod v) {
        return v.call(this);
    }
    
}
