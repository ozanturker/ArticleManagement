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
public interface ArticleDao {

    public ArrayList<Article> getAllArticles();

    public Article getArticle(int index);

    public void addArticle(Article article);

    public void insertDb();
    
    public void deleteAllArticles();
    
    public void print();
    
}
