/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w7;

/**
 *
 * @author marina
 */

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class SnakeIterator {

    static final int TILESIZE = 40;

    public static void main(String[] args) {

        // window construction
        JFrame frame = new JFrame("Iterator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Board Board = new Board(16, 9, TILESIZE);
        frame.getContentPane().add(Board);
        frame.pack();
        frame.setVisible(true);

        // mouse clicking starts the thread with iteration
        Board.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX() / TILESIZE;
                int y = e.getY() / TILESIZE;
                new Thread(new WorkerThread(Board, x, y)).start();
            }
        });
        // mouse moving - highlight a tile under the cursor
        Board.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX() / TILESIZE;
                int y = e.getY() / TILESIZE;
                Board.highlight(x, y);
            }
        });
    }
}
