package tictactoe;

import javax.swing.JButton;

class MyButton extends JButton {
    public int row, col; 
    public MyButton(String text, int r, int c) 
    { super(text); row = r; col = c; }
}
