/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w5;

/**
 *
 * @author marina
 */
public class W5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Document d=new Document();
        Chapter c=new Chapter();
        Paragraph p = new Paragraph("A simple paragraph. Build from 2 sentences."); //inside this constructor it must be converted to the collection of references to 'Character' objects and the RLE sequence.
        Paragraph p2 = new Paragraph("A simple paragraph. Build from 2 sentences."); //inside this constructor it must be converted to the collection of references to 'Character' objects and the RLE sequence.

        c.addParagraph(p);
        c.addParagraph(p2);
        
        d.addChapter(c);
        d.print();

        c.print();
    }
    
}
