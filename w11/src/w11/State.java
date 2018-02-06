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

import java.awt.Graphics;

public interface State {
	public void draw(Graphics g);
	public void move();
}
