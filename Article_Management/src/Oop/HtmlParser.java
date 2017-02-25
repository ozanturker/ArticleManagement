/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author ozan
 */
public class HtmlParser {

    private ArrayList<Exam> examlist = null;

    public HtmlParser(String url) {
        parseHtml(downloadHtml(url));
    }

    private Document downloadHtml(String url) {
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
            return doc;

        } catch (IOException ex) {
            Logger.getLogger(HtmlParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void parseHtml(Document doc) {

        examlist = new ArrayList<Exam>();
        Exam temp;

        Elements examnames = doc.getElementsByClass("col-sm-6");// arrayliste class adına gore butun sınav adları
        Elements examdates = doc.getElementsByClass("col-sm-2");// ve tarihlerini indirdik.

        for (int i = 1; i < examnames.size(); i++) {
            temp = new Exam();
            temp.setName(examnames.get(i).text());
            temp.setDate(examdates.get(i * 3).text());
            examlist.add(temp);// gereksiz tarihlerden arındırıp tarihlerle sınavlar bırlestırıldı.
        }
        examnames.clear();// Bosa alan kaplamaması ıcın elemetleri bosalttık.
        examdates.clear();
        for (Exam e : examlist) {
            System.out.println(e);
        }
    }

    public ArrayList<Exam> getExamlist() {
        return examlist;
    }

}
