import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.SAXEngine;
import org.jdom2.input.sax.XMLReaders;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class xmlParse {

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        try {
            SAXBuilder saxBuilder = new SAXBuilder(XMLReaders.NONVALIDATING);
            saxBuilder.setReuseParser(true);
            SAXEngine saxengine = saxBuilder.buildEngine();

            File inputFileMobility = new File(System.getProperty("user.dir")+"\\App6aIcons\\mobility\\-F--------MO---.svg");
            Document document = saxengine.build(inputFileMobility);
            System.out.println("Root element :" + document.getRootElement().getName());
            Element classElementMobility = document.getRootElement();
            List<Content> elementMobility = classElementMobility.cloneContent();

            File inputFileRanks = new File(System.getProperty("user.dir")+"\\App6aIcons\\ranks\\-F--------EB---.svg");
            Document documentRanks = saxengine.build(inputFileRanks);
            System.out.println("Root element :" + documentRanks.getRootElement().getName());
            Element classElementRanks = documentRanks.getRootElement();
             List<Content> elementRanks = classElementRanks.cloneContent();

            File inputFileTypes = new File(System.getProperty("user.dir")+"\\App6aIcons\\types\\sfapmhcm-------.svg");
            Document documentTypes = saxengine.build(inputFileTypes);
            System.out.println("Root element :" + documentTypes.getRootElement().getName());
            Element classElementTypes = documentTypes.getRootElement();
            List<Content> elementTypes = classElementTypes.cloneContent();


            Element full=new Element("svg");
            Element ele[]=new Element[3];
            for(int i=0;i<3;i++)
                ele[i]=new Element("g");



            for(Content el:elementTypes){
                ele[0].addContent(el);
            }
            ele[0].setAttribute("transform","translate(0 30)");
            full.addContent(ele[0]);

            for(Content el:elementMobility){
                ele[1].addContent(el);
            }
            ele[1].setAttribute("transform","translate(0 0)");
            full.addContent(ele[1]);


            for(Content el:elementRanks){
                ele[2].addContent(el);
            }
            ele[2].setAttribute("transform","translate(0 -10)");
            full.addContent(ele[2]);

            XMLOutputter xmlOutput = new XMLOutputter();
            Document documentFull=new Document (full);
            xmlOutput.output(documentFull, System.out);

            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(documentFull, new FileWriter(
                    "listeCompte.svg",false));



        } catch(JDOMException e) {
            e.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}