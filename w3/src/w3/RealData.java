/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w3;

/**
 *
 * @author marin
 */
// data stored in the database

interface Data {
    public int get(int idx);
    public void set(int idx, int value);
    public int size();
}

// a simple implementation
class RealData implements Data {
    private int[] tab;
    private static RealData rd = null;
    
    public RealData(){
        tab = new int[100];
    }
    public RealData(int size){
        super();
        tab = new int[size];
        System.out.println(tab);
    }

    @Override
    public int get(int idx) {
        return rd.tab[idx]; 
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void set(int idx, int value) {
        rd.tab[idx] = value; 
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        return rd.tab.length;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
