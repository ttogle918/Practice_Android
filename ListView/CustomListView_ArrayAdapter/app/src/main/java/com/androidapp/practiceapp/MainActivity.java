package com.androidapp.practiceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListViewBtnAdapter.ListBtnClickListener {
    ListViewBtnAdapter adapter;
    ListView listview;
    ArrayList<ListViewBtnItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setListener();
    }
    public void setListener(){
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                ListViewBtnItem item = (ListViewBtnItem) parent.getItemAtPosition(position) ;

                Drawable iconDrawable = item.getIconDrawable() ;

            }
        }) ;
    }

    public boolean loadItemsFromDB(ArrayList<ListViewBtnItem> list) {
        ListViewBtnItem item ;
        int i ;

        if (list == null) {
            list = new ArrayList<ListViewBtnItem>() ;
        }

        // 순서를 위한 i 값을 1로 초기화.
        i = 1 ;

        // 아이템 생성.
        item = new ListViewBtnItem() ;
        item.setIconDrawable(ContextCompat.getDrawable(this, R.drawable.profile_basic_128px)); ;
        item.setTextStr(Integer.toString(i) + "번 아이템입니다."); ;
        list.add(item) ;
        i++ ;

        item = new ListViewBtnItem() ;
        item.setIconDrawable(ContextCompat.getDrawable(this, R.drawable.profile_man_128px)) ;
        item.setTextStr(Integer.toString(i) + "번 아이템입니다.") ;
        list.add(item) ;
        i++ ;

        item = new ListViewBtnItem() ;
        item.setIconDrawable(ContextCompat.getDrawable(this, R.drawable.profile_woman_128px)) ;
        item.setTextStr(Integer.toString(i) + "번 아이템입니다.") ;
        list.add(item) ;

        return true ;
    }

    public void init() {
        items = new ArrayList<ListViewBtnItem>();

        loadItemsFromDB(items);
        adapter = new ListViewBtnAdapter(this, R.layout.listview_item, items, this);


        listview = (ListView) findViewById(R.id.listview1) ;
        listview.setAdapter(adapter);

    }

    @Override
    public void onListBtnClick(int position) {
        Toast.makeText(this, Integer.toString(position+1) + " Item is selected..", Toast.LENGTH_SHORT).show();
    }
}
