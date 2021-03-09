package com.androidapp.practiceapp;

import android.os.AsyncTask;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class OpenAPIDistinct extends AsyncTask<Void, Void, String> {
    String url;
    private ArrayList<String> distinct = new ArrayList<String>();

    public OpenAPIDistinct(String url) {
        this.url = url;
    }

    @Override
    protected String doInBackground(Void... voids) {
        InputSource is = new InputSource(new StringReader(url));

        // parsing할 url 지정(API 키 포함해서)
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }


        Document doc=null;
        try {
            // 여기 에러 -
            doc = dBuilder.parse(is);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();
        Element root = doc.getDocumentElement();
        root.normalize();   // tree 구조로 반환

        Log.d("Root", "doInBackground: root" + root.getNodeName());

        // 파싱할 tag
        NodeList children = root.getChildNodes();

        for(int i = 0; i < children.getLength(); i++){
            Node nNode = children.item(i);

            if(nNode.getNodeType() == Node.ELEMENT_NODE){
                Element eElement = (Element) nNode;

                Log.d("OPEN_API","SIGUN_NM  : " + getTagValue("SIGUN_NM", eElement));
            }	// for end
        }	// if end
        return null;
    }
    @Override
    protected void onPostExecute(String str) {
        super.onPostExecute(str);
    }

    private String getTagValue(String tag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        if(nValue == null)
            return null;
        return nValue.getNodeValue();

    }
}