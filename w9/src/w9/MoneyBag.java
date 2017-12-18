/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w9;

import java.util.LinkedList;

/**
 *
 * @author marina
 */

public class MoneyBag{
    
    private LinkedList<MoneyUnit> amount = new LinkedList<>();
    private CurrencyRatio currency;
    private double value;

    public MoneyBag(CurrencyRatio currency) {
      
    }

    public void addMoneyUnit(MoneyUnit m) {
        amount.add(m);
    }

    public LinkedList<MoneyUnit> getWallet() {
        return amount;
    }
    
    public void printWallet() {
        System.out.println("WALLET:");
        for(MoneyUnit m : amount) {
            System.out.println(m.toString());
        }
    }   
}
