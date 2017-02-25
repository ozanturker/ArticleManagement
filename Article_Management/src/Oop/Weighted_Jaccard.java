package Oop;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ozan
 */
public class Weighted_Jaccard implements Strategy {

    @Override
    public double calculateSimularityWithWord(ArrayList<Node> n1, ArrayList<Node> n2) {
        int min=0;
        int max=0;
        
        for (int i =0;i<n1.size();i++)
        {
            for (int j=0;j<n2.size();j++)
            {
                if (n1.get(i).getData().equals(n2.get(j).getData()))
                {
                    if (n1.get(i).getCount()<n2.get(j).getCount())
                    {
                        min+=n1.get(i).getCount();
                        max+= n2.get(j).getCount();
                    }
                    else
                    {
                        max+=n1.get(i).getCount();
                        min+= n2.get(j).getCount();
                    }
                }
            }
        
        }
        return (double)min/max*100;
    }

    @Override
    public double calculateSimularityWithTrigram(ArrayList<Node> n1, ArrayList<Node> n2) {
      return  calculateSimularityWithWord(n1, n2);
    }
    
    
    
    
    
}
