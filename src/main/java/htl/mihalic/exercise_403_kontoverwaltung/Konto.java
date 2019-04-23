/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htl.mihalic.exercise_403_kontoverwaltung;

/**
 *
 * @author Dominik
 */
public class Konto {
    private int betrag;

    public Konto(int betrag) {
        this.betrag = betrag;
    }

    public int getBetrag() {
        return betrag;
    }

    public void withdraw(int amount){
        betrag -= amount;
    }
    
    public void tranfer(int amount){
        betrag += amount;
    }
}
