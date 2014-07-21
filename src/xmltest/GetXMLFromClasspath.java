/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package xmltest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/**
 *
 * @author aa34357
 */
public class GetXMLFromClasspath {

      public static void main(String[] args) throws Exception {
        ClassLoader loader = GetXMLFromClasspath.class.getClassLoader();
        InputStream in = loader.getResourceAsStream("xmls");
        BufferedReader rdr = new BufferedReader(new InputStreamReader(in));
        String line;
        String file=new String();
        while ((line = rdr.readLine()) != null) {
            System.out.println("file:" + line);
            file = line;
        }
        rdr.close();
        
        
                 
       InputStream filepath = GetXMLFromClasspath.class.getResourceAsStream("/xmls/"+file);
       DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();           
       DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
       Document doc = docBuilder.parse(filepath);
       System.out.println(doc.getDocumentElement().getAttribute("id"));
                
           
    }
    
}
