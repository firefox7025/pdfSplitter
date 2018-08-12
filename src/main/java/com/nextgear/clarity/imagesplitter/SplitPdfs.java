package com.nextgear.clarity.imagesplitter;

import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class SplitPdfs {


    public static BufferedImage splitDoc(PDDocument document, int pageNum) {
        try {
            document.setResourceCache(new VoidResourceCache());
            return renderImage(document, pageNum);
        } catch (IOException e1) {
            System.out.println("Unable to split document " + e1);
            e1.printStackTrace();
            return new BufferedImage(0, 0, 0);
        }
    }


    public static BufferedImage renderImage(PDDocument pdDocument, int pageNum) throws IOException {
            PDFRenderer pdfRenderer = new PDFRenderer(pdDocument);
            return pdfRenderer.renderImageWithDPI(pageNum, 300, ImageType.RGB);
    }

    private static class VoidResourceCache extends DefaultResourceCache
    {
        @Override
        public void put(COSObject indirect, PDXObject xobject) throws IOException
        {
        }
    }
}
