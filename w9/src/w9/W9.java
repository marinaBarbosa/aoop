/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w9;

/**
 *
 * @author marina
 */

public class W9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CurrencyRatio c = new CurrencyRatio();
        c.addExchangeRatio(new ExchangeRatio("GBP", 4.0));
        c.addExchangeRatio(new ExchangeRatio("EUR", 2.0));
        
        MoneyBag mypocket = new MoneyBag(c);
        
        mypocket.addMoneyUnit(new MoneyUnit("GBP",45.36,c));
        c.addObserver(mypocket);
        mypocket.printWallet();
        
        c.updateRatio(new ExchangeRatio("GBP", 1.0));
        mypocket.printWallet();        
    } 
}
