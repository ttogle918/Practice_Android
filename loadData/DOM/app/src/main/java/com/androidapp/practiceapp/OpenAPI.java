package com.androidapp.practiceapp;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import java.io.IOException;


public class OpenAPI extends AsyncTask<Void, Void, Void> {
    private String url;
    private ListViewAdapter adapter;

    public OpenAPI(String url,  ListViewAdapter adapter) {

        this.url = url;
        this.adapter = adapter;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            Document document = Jsoup.connect(url).get();

            Elements e_BIZPLC_NM = document.getElementsByTag("BIZPLC_NM");
            Elements e_LOCPLC_FACLT_TELNO = document.getElementsByTag("LOCPLC_FACLT_TELNO");
            Elements e_REFINE_ROADNM_ADDR = document.getElementsByTag("REFINE_ROADNM_ADDR");
            Elements e_REFINE_LOTNO_ADDR = document.getElementsByTag("REFINE_LOTNO_ADDR");
            for (int i = 0 ; i < e_BIZPLC_NM.size(); i++){
                adapter.addItem(e_BIZPLC_NM.get(i).text(), e_LOCPLC_FACLT_TELNO.get(i).text(), e_REFINE_ROADNM_ADDR.get(i).text(), e_REFINE_LOTNO_ADDR.get(i).text());
            }
            Log.d("BIZPLC_NM", "Msg: " + e_BIZPLC_NM.text());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
