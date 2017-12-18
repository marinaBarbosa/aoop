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
public class W10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Figure rc = new Circle(20,12);
        Figure rt = new Triangule(54,10);
        Figure rs = new Square(54,10);
        
        VisitorMethod v = new Area();
        VisitorMethod v2 = new Scale(4);
        VisitorMethod v3 = new Move(2,2);
                
        Figure[] figures = {rc,rt,rs};
        
        for (Figure f: figures) {            
            f.call(v);
            f.call(v2);  
            f.call(v3);
        }
    }
}
    

