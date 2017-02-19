/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.comparison;
  
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.DomSerializer;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
/**
 *
 * @author welcome
 */
public class JSoupParser implements Parser {
  
@Override
    public String parse(String html) {
        TagNode tagNode = new HtmlCleaner().clean(html);
        org.w3c.dom.Document doc = (org.w3c.dom.Document) Jsoup.parse(html);
        
        
        
        XPath xpath = XPathFactory.newInstance().newXPath();
        String str = null;
        try 
        {
            str = (String) xpath.evaluate("//b[@class='priceLarge']\n",doc, XPathConstants.STRING);
        } 
        catch (XPathExpressionException e) 
        {
            e.printStackTrace();
            return "";
        }
        return str.replace(" ", "").replace("\n", "").trim();
    }
}

