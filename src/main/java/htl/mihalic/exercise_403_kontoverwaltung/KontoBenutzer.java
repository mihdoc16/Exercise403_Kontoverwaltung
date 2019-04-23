/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htl.mihalic.exercise_403_kontoverwaltung;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dominik
 */
public class KontoBenutzer extends Thread {
    private Konto konto = new Konto(100);
    private String name;
    private boolean help;

    public KontoBenutzer(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Random rand = new Random();
        while(true){
            int amount = rand.nextInt(50);
            if(amount <= konto.getBetrag()){
                konto.withdraw(amount);
                help = true;
                System.out.println(Thread.currentThread().getName() + ": Geld abgehoben");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(KontoBenutzer.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else{
                konto.tranfer(amount);
                help = false;
                System.out.println(Thread.currentThread().getName() + ": Geld eingezahlt");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(KontoBenutzer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public String getMessages() {
        while(true){
            if(help){
                return String.format(Thread.currentThread().getName() + ": Geld abgehoben\n");
            } else{
                return String.format(Thread.currentThread().getName() + ": Geld eingezahlt\n");
            }
        }
    }
    
}
