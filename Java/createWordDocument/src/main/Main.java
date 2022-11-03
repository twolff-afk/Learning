package main;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Main {

	public static void main(String[] args) {
		
		String filename = "helloWorld.doc";
        
        try {

            XWPFDocument doc = new XWPFDocument(OPCPackage.open(new FileInputStream(filename)));
            List<XWPFParagraph> paragraphList = doc.getParagraphs();
            
            for (XWPFParagraph para : paragraphList) {
                	
                    for (XWPFRun run : para.getRuns()) {
                        String text = run.text();
                        
                        System.out.println(text);
                        
                        if (text.equals("Platzhalter 1")) {
                        	text = text.replaceAll(text, "好");
                            run.setText(text, 0);
                        }
                        
                    }
                    
            }
            
            String docName = "newHelloWorld.doc";
            
            doc.write(new FileOutputStream(docName));
            
            File file = new File(docName);
            Desktop.getDesktop().print(file);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
	}
}
