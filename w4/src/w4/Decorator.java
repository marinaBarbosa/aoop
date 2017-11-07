/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w4;

/**
 *
 * @author marina
 */

abstract class Decorator implements IPiece {
    IPiece decorated;
    Decorator(IPiece decorated) {
            this.decorated = decorated;
    }
}
