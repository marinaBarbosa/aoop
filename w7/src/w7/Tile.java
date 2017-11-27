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

import java.awt.Color;

class Tile {
    // tile state
    private boolean value = false;
    // colors
    private static final Color on = new Color(0xffd700),
            off = new Color(0x1e90ff);
    public Color getColor() {
        return value ? on : off;
    }

    //change color
    public void flip() {
        value = !value;
    }
}
