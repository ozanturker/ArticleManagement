/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oop;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ozan
 */
public class Exam {

    private String name;
    private String date;
    private int remainingDays;

    public void remainingDate() {
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date now = new Date();
            Date examDate;

            examDate = dateFormat.parse(getDate());// string halindeki tarih Date objesine donustu.
            now = dateFormat.parse(dateFormat.format(now));// suanki zaman

            long difference = (Math.abs(examDate.getTime() - now.getTime())) / (24 * 60 * 60 * 1000);

            setRemainingDays((int) difference);

        } catch (ParseException ex) {
            Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getRemainingDays() {
        return remainingDays;
    }

    public void setRemainingDays(int remaining) {
        this.remainingDays = remaining;
    }

    @Override
    public String toString() {
        return name;
    }

}
