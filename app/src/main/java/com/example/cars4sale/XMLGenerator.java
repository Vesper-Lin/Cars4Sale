package com.example.cars4sale;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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


public class XMLGenerator extends GetRandom {

    public static void main(String[] args) {
        XMLGenerator xml = new XMLGenerator();

        for (int i = 1; i < 1001; i++) {
            cars.add(new Car(i, i, getRandomCarModelName(), getRandomLocationOfAu(), getRandomPrice(10000, 1000000), getRandomYear(2000, 2020)));
        }
        xml.saveData("app/src/main/assets/carData.xml");
    }

    public static List<Car> loadData(String filePath) {
        File f = new File(filePath);
        //create a DocumentBuilder instance: DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        List<Car> cars = new ArrayList<>();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d = db.parse(f); //parse file f, it is the root of the document tree
            d.getDocumentElement().normalize(); //remove redundancies such as spaces between <  >, line breaks, some white spaces, ...

            //get the list of nodes by tag name (all <car> items)
            NodeList nl = d.getElementsByTagName("car");

            for (int i = 0; i < nl.getLength(); i++) {
                Node n = nl.item(i);
                if (n.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) n;
                    Integer id = Integer.parseInt(element.getAttribute("id"));
                    Integer coding = Integer.parseInt(element.getAttribute("coding"));
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String location = element.getElementsByTagName("location").item(0).getTextContent();
                    Integer price = Integer.parseInt(element.getAttribute("price"));
                    Integer year = Integer.parseInt(element.getAttribute("year"));

                    Car car = new Car(id, coding, name, location, price, year);
                    cars.add(car);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cars;
    }

    public void saveData(String filePath) {
        File f = new File(filePath);

        //Defines a factory API that enables applications to obtain a parser that produces DOM object trees from XML documents. (see doc)
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            //DocumentBuilder obtain a Document from XML (parser)
            DocumentBuilder db = dbf.newDocumentBuilder(); //create a new instance of DocumentBuilder
            Document d = db.newDocument(); //obtain new instance of a DOM document

            //create the structure of my document
            Element rootElement = d.createElement("cars");
            d.appendChild(rootElement); //append the root to the document

            //loop through all people to create each car element
            for (Car cc : cars) {
                Element carElement = d.createElement("car");
                carElement.setAttribute("id", Integer.toString(cc.getId()));

                Element codingElement = d.createElement("coding");
                codingElement.appendChild(d.createTextNode(String.valueOf(cc.getCoding())));
                carElement.appendChild(codingElement);

                Element nameElement = d.createElement("name");
                nameElement.appendChild(d.createTextNode(cc.getName()));
                carElement.appendChild(nameElement);

                Element locationElement = d.createElement("location");
                locationElement.appendChild(d.createTextNode(cc.getLocation()));
                carElement.appendChild(locationElement);

                Element priceElement = d.createElement("price");
                priceElement.appendChild(d.createTextNode(String.valueOf(cc.getPrice())));
                carElement.appendChild(priceElement);

                Element yearElement = d.createElement("year");
                yearElement.appendChild(d.createTextNode(String.valueOf(cc.getYear())));
                carElement.appendChild(yearElement);

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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}