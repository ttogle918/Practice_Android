package com.androidapp.practiceapp;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class OpenAPIDistinct extends AsyncTask<Void, Void, Void> {
    String url;
    private ArrayList<String> distint = new ArrayList<String>();

    public OpenAPIDistinct(String url) {
        this.url = url;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            Document document = Jsoup.connect(url).get();
            Elements e_SIGUN_NM = document.getElementsByTag("SIGUN_NM");
            Collections.sort(e_SIGUN_NM, new HangeulDesc() );
            distint.add(e_SIGUN_NM.get(0).text());
            Log.d("e_SIGUN_NM", "Msg: " + distint);

            for (int i = 1; i < e_SIGUN_NM.size(); i++) {
                if (e_SIGUN_NM.get(i-1).text().compareTo(e_SIGUN_NM.get(i).text()) != 0) {
                    distint.add(e_SIGUN_NM.get(i).text());
                }
            }
            Log.d("e_SIGUN_NM", "Msg: " + distint);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private class HangeulAsc implements Comparator<Element> {
        @Override
        public int compare(Element arg0, Element arg1) {
            return arg1.text().compareTo(arg0.text());
        }
    }
    private class HangeulDesc implements Comparator<Element> {
        @Override
        public int compare(Element arg0, Element arg1) {
            // TODO Auto-generated method stub
            return arg0.text().compareTo(arg1.text());
        }
    }
}