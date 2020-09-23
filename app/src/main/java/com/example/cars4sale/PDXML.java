package com.example.cars4sale;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class PDXML {

    List<car> cars;

    public PDXML()
    {
        cars = new ArrayList<car>();
    }

    public List<car> loadData(String filePath)
    {
        File f = new File(filePath);
        //create a DocumentBuilder instance: DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //list
        List<car> lp = new ArrayList<car>();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d = db.parse(f); //parse file f, it is the root of the document tree
            d.getDocumentElement().normalize(); //remove redundancies such as spaces between <  >, line breaks, some white spaces, ...

            //get the list of nodes by tag name (all <person> items)
            NodeList nl = d.getElementsByTagName("car");

            for(int i = 0; i < nl.getLength(); i++)
            {
                Node n = nl.item(i);
                if(n.getNodeType() == Node.ELEMENT_NODE) {
                    Element element		= (Element) n;
                    Integer id 			= Integer.parseInt(element.getAttribute("id"));
                    String firstname 	= element.getElementsByTagName("carname").item(0).getTextContent();
                    String lastname 	= element.getElementsByTagName("location").item(0).getTextContent();
                    Integer price 			= Integer.parseInt(element.getAttribute("price"));

                    car p 			= new car(id, firstname, lastname,price);
                    lp.add(p);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return lp;
    }

    public void saveData(String filePath)
    {
        File f = new File(filePath);

        //Defines a factory API that enables applications to obtain a parser that produces DOM object trees from XML documents. (see doc)
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            //DocumentBuilder obtain a Document from XML (parser)
            DocumentBuilder db = dbf.newDocumentBuilder(); //create a new instance of DocumentBuilder
            Document d = db.newDocument(); //obtain new instance of a DOM document

            //create the structure of my document
            Element rootElement = d.createElement("People");//<People>
            d.appendChild(rootElement); //append the root to the document

            //loop through all people to create each person element
            for(car cc : cars)
            {
                Element carElement = d.createElement("car");//<Person>..
                carElement.setAttribute("id", Integer.toString(cc.getId()));//<Person id="1">..

                Element carnameElement = d.createElement("carName");//<FirstName> ... </FirstName>
                carnameElement.appendChild(d.createTextNode(cc.getcarname()));//<FirstName> here goes firstname </FirstName>
                carElement.appendChild(carnameElement);//<Person id="1"><FirstName> here goes firstname </FirstName></Person>

                Element locationElement = d.createElement("location");
                locationElement.appendChild(d.createTextNode(cc.getlocation()));
                carElement.appendChild(locationElement);

                Element priceElement = d.createElement("price");//<FirstName> ... </FirstName>
                priceElement.appendChild(d.createTextNode(String.valueOf(cc.getPrice())));//<FirstName> here goes firstname </FirstName>
                carElement.appendChild(priceElement);

                rootElement.appendChild(carElement);
            }

            //transform a source tree into a result tree
            //Used to process XML from a variety of sources and write the transformation output to a variety of sinks (see transformer documentation)
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            //set encoding
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            //indent the output document
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            //create document
            DOMSource source = new DOMSource(d); //Acts as a holder for a transformation Source tree in the form of a Document Object Model (DOM) tree.
            StreamResult result = new StreamResult(f);//Acts as a holder for a transformation result, which may be XML,..
            transformer.transform(source, result); //Transform the XML Source to a Result.

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    //产生汽车的价格
    public static int getrandom(int start,int end) {
        int num=(int) (Math.random()*(end-start+1)+start);
        return num;
    }

    //产生汽车的型号
    public static String getcarname() {
        String ran = "";
        String[] doc = {"a", "b", "c", "d", "e"};
        int index = (int) (Math.random() * doc.length);
        ran = doc[index];
        return ran;
    }

    public static String getlocation() {
        String ran = "";
        String[] doc = {"f", "g", "k", "o", "p"};
        int index = (int) (Math.random() * doc.length);
        ran = doc[index];
        return ran;
    }

    //产生汽车的生产地
    public static void main(String[] args)
    {
        PDXML xml = new PDXML();

        for(int i =1;i<10;i++){
            xml.cars.add(new car(i,getcarname(),getlocation(),getrandom(10,100)));
        }
        xml.saveData(".idea/cardata.xml");


    }
}