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

// in this version this thread doesn't use the iterator - change it
class WorkerThread implements Runnable {

    private Board p;
    private int x, y;
    
    // x, y - initial position of iteration
    public WorkerThread(Board k, int x, int y) {
        this.p = k;
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void run() {
        Iterator<Tile> iter;
        iter = p.iterator();
        iter.setX(getX());
        iter.setY(getY());

        while(iter.hasNext()) {
            Tile t = (Tile) iter.next();
            if(t != null) {
                    t.flip();
                    p.repaint();
            }
            try {	//wait 
                 Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                 e.printStackTrace();
            }
        }
    }
}
   