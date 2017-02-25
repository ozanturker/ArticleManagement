/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oop;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 *
 * @author ozan
 */
public class PdfReader {

    private String context;

    public String readPdf(String path) {
        PDDocument pd = null;
        try {

            File input = new File(path);

            pd = PDDocument.load(input);
            PDFTextStripper stripper = new PDFTextStripper();
            context = stripper.getText(pd);

            pd.close();
            return context;

        } catch (Exception ex) {
            Logger.getLogger(PdfReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
