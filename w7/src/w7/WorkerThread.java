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

    public void run() {
        // iteration using 2 'for' loops - to be replaced with the iterator application
        /*for (int i = y; i < p.getRows(); ++i) {
            int j;
            if (i == y) {
                j = x;
            } else {
                j = 0;
            }
            for (; j < p.getCols(); ++j) {
                p.getAt(i, j).flip(); //change color
                p.repaint();	*/	
//refresh the screen
                try {	//wait 
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
   // }
//}