/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w11;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author marina
 */

public class FlyStates extends JPanel implements Runnable {
	private Fly[] ar;
	public FlyStates()	{
		this.setPreferredSize(new Dimension(640, 480));
		ar = new Fly[30];
		for(int i = 0; i < ar.length; ++i)
			ar[i] = new Fly();
	}
	
	public void paintComponent(Graphics g)	{
		super.paintComponent(g);
		for(int i = 0; i < ar.length; ++i)
			ar[i].draw(g);
	}
	
	public void run() {
		while (true) {
			for(int i = 0; i < ar.length; ++i)
				ar[i].move();
			repaint();
			try {
				Thread.currentThread().sleep(20);
			} catch(InterruptedException e){ e.printStackTrace();}
		}
	}
}