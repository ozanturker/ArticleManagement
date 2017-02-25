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
public class Jaccard implements Strategy {

    

    @Override
    public double calculateSimularityWithWord(ArrayList<Node> n1, ArrayList<Node> n2) {

        int kesisim =0;
       //kesişim
        for (int i = 0; i < n1.size(); i++) {
            for (int j = 0; j < n2.size(); j++) {
                if (n1.get(i).getData().equals(n2.get(j).getData())) {
                    kesisim++;

                } 
            }
        }
        
        
        int birlesim = (n1.size()+n2.size())-kesisim;
    

        
      double oran =(kesisim/birlesim)*100;
            
       return oran;
        
        
    }

    @Override
    public double calculateSimularityWithTrigram(ArrayList<Node> n1, ArrayList<Node> n2) {
               
       return calculateSimularityWithWord( n1, n2);

    }
    
 

}
