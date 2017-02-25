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
public class ArraylistIterator implements Container {

    ArrayList<Article> arrayList;
    public ArraylistIterator(ArrayList<Article> arrayList) {
        this.arrayList=arrayList;
    }

    
    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {

            if (index < arrayList.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if (this.hasNext()) {
                return arrayList.get(index++);
            }
            return null;
        }
    }
}
