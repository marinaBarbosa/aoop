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

public interface VisitorMethod {
    public Object call(Circle c);
    public Object call(Triangule t);
    public Object call(Square s);
} 