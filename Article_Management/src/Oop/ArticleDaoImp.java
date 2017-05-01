/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oop;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import java.util.ArrayList;

/**
 *
 * @author ozan
 */
public class ArticleDaoImp implements ArticleDao {

    ArrayList<Article> articleList;
     ArraylistIterator arraylistIterator;
    
    public ArticleDaoImp() {
        articleList = new ArrayList<Article>();
        arraylistIterator = new ArraylistIterator(articleList);
        //git
    }

    @Override
    public ArrayList<Article> getAllArticles() {

        return articleList;
    }

    @Override
    public Article getArticle(int index) {

        return articleList.get(index);
    }

    @Override
    public void addArticle(Article article) {
        articleList.add(article);
    }

    public void deleteAllArticles() {
        for (Article a : articleList) {
            articleList.remove(a);
        }
    }

    @Override
    public void insertDb() {

        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("articledb");

        DBCollection collection = db.getCollection("Article");
       
        for (Article a : getAllArticles()) {

            BasicDBObject document = new BasicDBObject();

            document.put("id", a.getId());
            document.put("title", a.getTitle());
            document.put("authors", a.getAuthors());
            document.put("venue", a.getVanue());
            document.put("year", a.getYear());
            document.put("content", a.getContent());

            collection.insert(document);

        }

    }

    @Override
    public void print() {
        for(Iterator iter = arraylistIterator.getIterator(); iter.hasNext();){
         
         System.out.println(iter.next().toString());
      } 	
    }

}
