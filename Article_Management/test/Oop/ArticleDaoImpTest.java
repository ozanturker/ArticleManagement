/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oop;

import Oop.ArticleDaoImp;
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
public class ArticleDaoImpTest {
    
    public ArticleDaoImpTest() {
    }
    
   
    @Test
    public void testDeleteAllArticles() {
        System.out.println("deleteAllArticles");
        ArticleDaoImp instance = new ArticleDaoImp();
        instance.deleteAllArticles();
        if (instance.getAllArticles().size()!=0)
            fail("failed");
        // TODO review the generated test code and remove the default call to fail.
       
    }

  
    
}
