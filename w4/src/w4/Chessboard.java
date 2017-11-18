/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*; 


/**
 *
 * @author marina
 */

public class Chessboard extends JPanel {
    public static final int ZEROX = 23;
    static final int ZEROY = 7;
    private HashMap<Point, IPiece> board = new HashMap<Point, IPiece>();
    public void drop(IPiece p, int x, int y)	{
        if (p != null){
            repaint();
            p.moveTo(x,y);
            board.put(new Point(x, y), p); // jeśli na tych współrzędnych
                                            //jest już jakaś figura, znika ona z planszy
                                            //(HashMap nie dopuszcza powtórzeń)
        }
    }
    public IPiece take(int x, int y)	{
        repaint();
        return board.remove(new Point(x, y));
    }
	
    private Image image;
    private IPiece dragged = null;
    private Point mouse = null;
	
    @Override
    public void paint(Graphics g){
        g.drawImage(image, 0, 0, null);

        for(Map.Entry<Point, IPiece> e : board.entrySet()) {
            Point pt = e.getKey();
            IPiece pc = e.getValue();
            pc.draw((Graphics2D)g);
        }
        if(mouse != null && dragged != null) {
            dragged.draw((Graphics2D)g);
        }
        else {
            repaint();
        }
           
    }
    
    Chessboard() {
        board.put(new Point(0,2), new AffineDecorator(new Piece(11,0,2)));
        board.put(new Point(0,6), new AffineDecorator(new Piece(0,0,6)));
        board.put(new Point(1,4), new AffineDecorator(new Piece(6,1,4)));
        board.put(new Point(1,5), new AffineDecorator(new Piece(5,1,5)));
        board.put(new Point(3,7), new AffineDecorator(new Piece(1,3,7)));
        board.put(new Point(4,3), new AffineDecorator(new Piece(6,4,3)));
        board.put(new Point(4,4), new AffineDecorator(new Piece(7,4,4)));
        board.put(new Point(5,4), new AffineDecorator(new Piece(6,5,4)));
        board.put(new Point(5,6), new AffineDecorator(new Piece(0,5,6)));
        board.put(new Point(6,5), new AffineDecorator(new Piece(0,6,5)));
        board.put(new Point(7,4), new AffineDecorator(new Piece(0,7,4)));

        image = new ImageIcon(Chessboard.class.getResource("/img/board3.png")).getImage();
        setPreferredSize(new Dimension(image.getWidth(null), image.getHeight(null)));

        this.addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent ev) {
                        dragged = take((ev.getX()-ZEROX)/Piece.TILESIZE, (ev.getY()-ZEROY)/Piece.TILESIZE);
                        mouse = ev.getPoint();
                }
                public void mouseReleased(MouseEvent ev) {
                        drop(dragged, (ev.getX()-ZEROX)/Piece.TILESIZE, (ev.getY()-ZEROY)/Piece.TILESIZE);
                        dragged = null;
                        undo.setEnabled(true);
                }
        });
        this.addMouseMotionListener(new MouseMotionAdapter(){
                public void mouseDragged(MouseEvent ev)	{
                        mouse = ev.getPoint();
                        repaint();
                }
        });
    }
	
    class UndoButton implements ActionListener	{
            public void actionPerformed(ActionEvent ev)
            {
                    System.out.println("UNDO");
                    redo.setEnabled(true);
            }
    }

    class RedoButton implements ActionListener 	{
            public void actionPerformed(ActionEvent ev) 	{
                    System.out.println("REDO");
            }
    }
	
    private JButton undo, redo;
    public static void main(String[] args)	{
        JFrame frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Chessboard board = new Chessboard();

        JToolBar bar = new JToolBar();
        board.undo = new JButton(new ImageIcon(Chessboard.class.getResource("/img/undo.png")));
        board.redo = new JButton(new ImageIcon(Chessboard.class.getResource("/img/redo.png")));
        board.undo.addActionListener(board.new UndoButton());
        board.redo.addActionListener(board.new RedoButton());
        board.undo.setEnabled(false);
        board.redo.setEnabled(false);
        bar.add(board.undo);
        bar.add(board.redo);

        frame.add(bar, BorderLayout.PAGE_START);
        frame.add(board);

        frame.pack();
        frame.setVisible(true);
    }
}
    

