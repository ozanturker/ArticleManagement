/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oop;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import org.apache.lucene.analysis.ngram.NGramTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

/**
 *
 * @author ozan
 */
public class WordAnalyzer {

    ArrayList<Node> list;
    Map<String, Integer> wordCounts ;

    public ArrayList<Node> splitWord(String context) {// String contexte cevir

        
        String[] liste = context.split("[\\p{Punct}\\s]+");

            wordCounts = new TreeMap<String, Integer>();
        for (int i = 0; i < liste.length; i++) {
            String next = liste[i].toLowerCase().trim();
            System.out.println(next);

            if (!wordCounts.containsKey(next)) {

                wordCounts.put(next, 1);

            } else {

                wordCounts.put(next, wordCounts.get(next) + 1);
            }
        }
                
        // get cutoff and report frequencies
        /*  Scanner console = new Scanner(System.in);

        System.out.println("Total words = " + wordCounts.size());
        System.out.print("Minimum number of occurrences for printing? ");

        int min = console.nextInt();
         */
        for (String word : wordCounts.keySet()) {
            int count = wordCounts.get(word);
            System.out.println(count + "\t" + word+"sss");

        }

        return order(wordCounts);

    }

     public ArrayList<Node> TrigramGenerator() throws IOException {

        Map<String, Integer> trigramCounts = new TreeMap<String, Integer>();

        for (String word : wordCounts.keySet()) {
            if (word.length()>3)  
            {
            Reader reader = new StringReader(" " + word + " ");
            
            NGramTokenizer gramTokenizer = new NGramTokenizer(3, 3);
            gramTokenizer.setReader(reader);
            gramTokenizer.reset();
            CharTermAttribute charTermAttribute = gramTokenizer.addAttribute(CharTermAttribute.class);

            while (gramTokenizer.incrementToken()) {
                String token = charTermAttribute.toString();
                if (!trigramCounts.containsKey(token)) {
                    trigramCounts.put(token, wordCounts.get(word));
                } else {
                    trigramCounts.put(token, trigramCounts.get(token) + wordCounts.get(word));
                }
            }
            }

        }
        return order (trigramCounts);
    }
    public ArrayList<Node> order(Map<String, Integer> map) {

        list = new ArrayList<Node>();

        Node node;
        int counter = 0;
        
         
        for (String word : map.keySet()) {
            node = new Node();
            node.setData(word);
            node.setCount(map.get(word));
           
                list.add(node);
                counter++;
          
                Collections.sort(list, new Comparator<Node>() {
                    @Override
                    public int compare(Node n1, Node n2) {
                        Integer a1=n1.getCount();
                        Integer a2 = n2.getCount();
                        return (a1 > a2 ? -1 : (a1 == a2 ? 0 : 1)); // Ascending
                    }
                        
                });
            }
            return list;
    }

}
