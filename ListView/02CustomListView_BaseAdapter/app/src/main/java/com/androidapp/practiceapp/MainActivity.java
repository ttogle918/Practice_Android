package com.androidapp.practiceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListViewAdapter adapter;
    ListView listview;

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

                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position) ;

                String titleStr = item.getTitleStr() ;
                String descStr = item.getDescStr() ;
                Drawable iconDrawable = item.getIconDrawable() ;

                Toast toast = Toast.makeText(getApplicationContext(), titleStr, Toast.LENGTH_SHORT);
                toast.show();
            }
        }) ;
    }

    public void init() {
        adapter = new ListViewAdapter();

        listview = (ListView) findViewById(R.id.listview1) ;
        listview.setAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile_basic_128px), "basic", "Account Human 512px");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile_woman_128px), "woman", "Account Woman 512px");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile_man_128px), "man", "Account Human Man 512px");
    }
}
