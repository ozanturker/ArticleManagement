/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oop;

/**
 *
 * @author ozan112233
 */
public class Article {

    private int id;
    private String title;
    private String authors;
    private String vanue;
    private int year;
    private String content;
    private String location;

    public Article(int id, String title, String authors, String vanue, int year) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.vanue = vanue;
        this.year = year;
        content = "";
        location = "";
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getVanue() {
        return vanue;
    }

    public void setVanue(String vanue) {
        this.vanue = vanue;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return  ""+id ;
    }

}
