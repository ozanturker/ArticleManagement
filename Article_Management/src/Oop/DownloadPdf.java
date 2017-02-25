/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oop;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 *
 * @author ozan
 */
public class DownloadPdf {

    public String DownloadPdf(int ArticleId) {

        FirefoxProfile profile = new FirefoxProfile();
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\ozan\\Desktop\\geckodriver.exe");
        //Set Location to store files after downloading.
        profile.setPreference("browser.download.dir", "D:\\Downloaded Articles");
        profile.setPreference("browser.download.folderList", 2);

        //Set Preference to not show file download confirmation dialogue using MIME types Of different file extension types.
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "application/pdf");

        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("pdfjs.disabled", true);

        //Pass FProfile parameter In webdriver to use preferences to download file.
        FirefoxDriver driver = new FirefoxDriver(profile);

        // Open APP to download application
        driver.get("http://dl.acm.org/citation.cfm?id=" + ArticleId);

        // Click to download
        driver.findElement(By.name("FullTextPDF")).click();

        try {
            Thread.sleep(8000);// inene kadar beklettık
            driver.quit();
        } catch (InterruptedException ex) {
            Logger.getLogger(DownloadPdf.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lastDownloadedFile();

    }

    public String lastDownloadedFile() {
        File folder = new File("D:\\Downloaded Articles\\");
        File[] listOfFiles = folder.listFiles();
        long sondegistirilen = 0;
        File sonfile = null;
        for (int i = 0; i < listOfFiles.length; i++) {

            if (sondegistirilen < listOfFiles[i].lastModified()) {
                sondegistirilen = listOfFiles[i].lastModified();
                sonfile = listOfFiles[i];
            }
        }
        return sonfile.getAbsolutePath();
    }
}
/*  public void Sirala()
     {
       
        ArrayList<String> FileNames = new ArrayList<String>();
        boolean Varmi = false;
        String EnBuyukName = "";
        int EnBuyukTarih = 0;
        
        
        for(int i = 0;i < listOfFiles.length;i++)
        {
            listOfFiles[i].lastModified();
            Varmi = false;
            for(int k = 0;k < FileNames.size();k++)
            {
                  
            }
            if(!Varmi) FileNames.add(listOfFiles[i].getName());
        }
        
     }
     
      public void nameChanger(int id)
    {
        File folder = new File("D:\\Downloaded Articles\\");
        File[] listOfFiles = folder.listFiles();
        listOfFiles[0].renameTo(new File("D:\\Downloaded Articles\\"+id+".pdf"));
        
      
        
    }*/
 /*  public static void downloadFileFromURL(String urlString, File destination) {  
            HttpURLConnection connection = null;
         try {
             System.out.println("opening connection");
             URL url = new URL(urlString);
              connection = (HttpURLConnection) url.openConnection();
              System.out.println(connection.getResponseMessage());
              connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36"); 
             
             InputStream in = url.openStream();
             FileOutputStream fos = new FileOutputStream(destination);
             
             System.out.println("reading from resource and writing to file...");
             int length = -1;
             byte[] buffer = new byte[1024];// buffer for portion of data from connection
             while ((length = in.read(buffer)) > -1) {
                 fos.write(buffer, 0, length);
             }
             fos.close();
             in.close();
             System.out.println("File downloaded");
         } catch (MalformedURLException ex) {
             Logger.getLogger(SeleniumDeneme.class.getName()).log(Level.SEVERE, null, ex); 
         }
         catch (IOException ex) {
             Logger.getLogger(SeleniumDeneme.class.getName()).log(Level.SEVERE, null, ex);}*/
