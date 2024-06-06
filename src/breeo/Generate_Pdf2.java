
package breeo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import java.io.OutputStream;
import java.io.File;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.VerticalText;
import java.awt.Canvas;
import java.awt.Desktop;
import java.io.FileInputStream;
import javax.print.Doc;
import javax.print.DocFlavor;

import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import java.awt.print.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;

public class Generate_Pdf2 {

   
    public static void main(String[] args) throws IOException 
    {
        try{
        String file_name="C:\\Breoo Namkeen\\Shop Bills\\Color Bill.pdf";
        String outputFilePath="C:\\Breoo Namkeen\\Shop Bills\\4.pdf";
        OutputStream fos = new FileOutputStream(new File(outputFilePath));
        PdfReader pdfReader = new PdfReader(file_name);
        PdfStamper pdfStamper = new PdfStamper(pdfReader, fos);
        
        for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
 
               //getOverContent() allows you to write content on TOP of existing pdf content.
               //getUnderContent() allows you to write content on BELOW of existing pdf content.
                  
                  PdfContentByte pdfContentByte = pdfStamper.getOverContent(i);
 
                  // Add text in existing PDF
                  pdfContentByte.beginText();
                  pdfContentByte.setFontAndSize(BaseFont.createFont
                                                    (BaseFont.TIMES_BOLD, //Font name
                                                      BaseFont.CP1257, //Font encoding
                                                     BaseFont.EMBEDDED) //Font embedded
                                                      , 14);
                  pdfContentByte.setFontAndSize(BaseFont.createFont(BaseFont.TIMES_BOLD,BaseFont.CP1257,BaseFont.EMBEDDED),11);
                  pdfContentByte.showTextAligned(Element.ALIGN_CENTER,"Mohit Gullani", 470, 750, 270);//Name Upper
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_CENTER,"Mohit Gullani", 470, 320, 270);//Name Lower
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_CENTER,"08-03-2001", 470,493, 270);//Date Upper
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_CENTER,"08-03-2001", 470,50, 270);//Date Lower
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_CENTER,"18/5 Jeevandeep Colony", 449,750, 270);//Address Upper
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_CENTER,"18/5 Jeevandeep Colony", 449,320, 270);//Address Lower
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_CENTER,"9826782684", 427,550, 270);//Contact Upper
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_CENTER,"9826782684", 427,115, 270);//Contact Lower
                  
                  pdfContentByte.setFontAndSize(BaseFont.createFont(BaseFont.TIMES_ROMAN,BaseFont.CP1257,BaseFont.EMBEDDED),11);
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_LEFT,"1", 380,852, 270);//SNO1 Upper
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_LEFT,"Laung Sev", 380,830, 270);//Item1 Upper
                  
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_LEFT,"200", 380,625, 270);//Weight1 Upper
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_LEFT,"3", 380,587, 270);//Quantity1 Upper
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_LEFT,"52", 380,555, 270);//Amount1 Upper
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_LEFT,"156", 380,495, 270);//Total1 Upper
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_LEFT,"1", 380,410, 270);//SNO1 Lower
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_LEFT,"Laung Sev", 380,387, 270);//Item1 Lower
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_LEFT,"200", 380,183, 270);//Weight1 Lower
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_LEFT,"3", 380,145, 270);//Quantity1 Lower
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_LEFT,"52", 380,112, 270);//Amount1 Lower
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_LEFT,"156", 380,55, 270);//Total1 Lower
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_LEFT,"2", 365,852, 270);//SNO2 Upper
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_LEFT,"Ratlami Sev", 365,810, 270);//Item2 Upper
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_LEFT,"52", 365,540, 270);//Amount1 Upper
                  
                  pdfContentByte.setFontAndSize(BaseFont.createFont(BaseFont.TIMES_BOLD,BaseFont.CP1257,BaseFont.EMBEDDED),13);
                  
                  pdfContentByte.setColorFill(BaseColor.WHITE);
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_LEFT,"150", 64,495, 270);//Net Amount Upper
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_LEFT,"150", 64,58, 270);//Net Amount Lower
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_LEFT,"400 gm", 64,742, 270);//Net Weight Upper
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_LEFT,"400 gm", 64,301, 270);//Net Weight Lower
                  
                  pdfContentByte.setFontAndSize(BaseFont.createFont(BaseFont.TIMES_BOLD,BaseFont.CP1257,BaseFont.EMBEDDED),15);
                  
                  pdfContentByte.setColorFill(BaseColor.BLACK);
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_LEFT,"12", 553,495, 270);//Bill No Upper
                  
                  pdfContentByte.showTextAligned(Element.ALIGN_LEFT,"12", 553,55, 270);//Bill No Lower
                  
                  System.out.println("Text added in "+outputFilePath);
                  
                  pdfContentByte.endText();
           }
        pdfStamper.close();
        System.out.println("Finished");
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        Desktop.getDesktop().open(new File("C:\\Breoo Namkeen\\Shop Bills\\4.pdf"));
        
        
        
        

        
        
        
        
        
        
        
        
        
}
}


    
