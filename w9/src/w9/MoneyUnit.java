/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w9;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author marina
 */

public class MoneyUnit implements Observer {
    
    HashMap<String,ExchangeRatio> c;
    private String currency;
    private double valueAdd;
    public double total;

    @Override
    public String toString() {
        return "MoneyUnit{" + "c=" + c + ", currency=" + currency + ", valueAdd=" + valueAdd + ", total=" + total + '}';
    }

    public MoneyUnit(String currency, double valueAdd, CurrencyRatio cr) {
       
        this.currency = currency;
        this.valueAdd = valueAdd;
        this.total = (cr.getExchangeRate(this.currency) * valueAdd) / (cr.getExchangeRate("EUR"));
    }

    public String getCurrency() {
        return currency;
    }

    public double getValueAdd() {
        return valueAdd;
    }

    public void setValueAdd(double valueAdd) {
        this.valueAdd = valueAdd;
    }
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public void update(Observable o, Object arg) {
        c = (HashMap<String,ExchangeRatio>)arg;
        this.total = (valueAdd * c.get(this.currency).getValue())/c.get("EUR").getValue();
    }
}
