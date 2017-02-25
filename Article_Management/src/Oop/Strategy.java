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
public interface Strategy {
    public double calculateSimularityWithWord (ArrayList<Node> n1,ArrayList<Node> n2);
    
    public double  calculateSimularityWithTrigram (ArrayList<Node> n1,ArrayList<Node> n2);
}
