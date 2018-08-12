package com.nextgear.clarity.imagesplitter;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        try {
            List<File> paths = FindPdfs.findPaths("/home/amontgomery/Desktop/pdf/completed");
            for(File x : paths) {
                PDDocument pdDocument = PDDocument.load(x, MemoryUsageSetting.setupTempFileOnly());
                for(int p = 0;  p < pdDocument.getNumberOfPages(); p++) {
                    FileUtils.writeImage(SplitPdfs.splitDoc(pdDocument, p));
                }
                pdDocument.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
}
