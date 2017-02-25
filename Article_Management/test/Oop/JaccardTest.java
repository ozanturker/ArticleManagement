/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oop;

import Oop.Node;
import Oop.Jaccard;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ozan
 */
public class JaccardTest {
    
    public JaccardTest() {
    }
    
    @Test
    public void testCalculateSimularityWithWord() {
        System.out.println("calculateSimularityWithWord");
        Node node1 = new Node();
        node1.setData("ev");
        node1.setCount(3);
         Node node2 = new Node();
        node2.setData("araba");
        node2.setCount(2);
         Node node3 = new Node();
        node3.setData("ev");
        node3.setCount(1);
        Node node4 = new Node();
        node4.setData("araba");
        node4.setCount(1);
        ArrayList<Node> n1=new ArrayList<Node>()  ;
        ArrayList<Node> n2 = new ArrayList<Node>();
        n1.add(node3);
        n1.add(node2);
        n2.add(node1);
        n2.add(node4);
        for (Node n : n1)
            System.out.println(n.getData());
         for (Node n : n2)
            System.out.println(n.getData());
        
        Jaccard instance = new Jaccard();
        double expResult = 100;
        double result = instance.calculateSimularityWithWord(n1, n2);
        assertEquals(expResult, result,0.1);
        // TODO review the generated test code and remove the default call to fail.
        
    }

   
    
}
