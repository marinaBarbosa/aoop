/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w9;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author marina
 */

import java.util.Observable;

public class CurrencyRatio extends Observable{
    
    private HashMap<String,ExchangeRatio> exchangeRates = new HashMap<String,ExchangeRatio>();
    private LinkedList<MoneyBag> observers = new LinkedList<> ();

    public double getExchangeRate(String s) {
        return exchangeRates.get(s).getValue();
    }
    
    public void addExchangeRatio(ExchangeRatio e) {
        exchangeRates.put(e.getCurrency(), e);
        System.out.println("CURRENCY: " + e.getCurrency() + "\nRATIO: " + e.getValue());
        System.out.println("---------");
        setChanged();
        notifyObservers(this.exchangeRates);
    }
    
    public void updateRatio(ExchangeRatio e) {
        exchangeRates.replace(e.getCurrency(),exchangeRates.get(e.getCurrency()) ,e);
        System.out.println("CURRENCY: " + e.getCurrency() + "\nRATIO: " + e.getValue());
        System.out.println("---------");
        setChanged();
        notifyObservers(this.exchangeRates);
    }

    public void addObserver (MoneyBag m) {
        observers.add(m);
        for(MoneyBag money: observers ) {
            for (MoneyUnit mUnit : money.getWallet() ) {
                addObserver(mUnit);
            }
        }
    }
}
