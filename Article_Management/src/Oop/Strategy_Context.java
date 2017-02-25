/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oop;

import java.util.ArrayList;

/**
 *
 * @author ozan
 */
public class Strategy_Context {
    private Strategy strategy;

    public Strategy_Context(Strategy strategy) {
        this.strategy = strategy;
    }
    
    public double executeStrategyWord(ArrayList<Node> n1, ArrayList<Node> n2){
     return strategy.calculateSimularityWithWord(n1, n2);
   }
     public double executeStrategyTrigram(ArrayList<Node> n1, ArrayList<Node> n2){
     return strategy.calculateSimularityWithTrigram(n1, n2);
   }
    
}
