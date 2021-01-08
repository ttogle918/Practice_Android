package com.androidapp.practiceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {
    ArrayAdapter adapter;
    ArrayList<String> items;
    ListView listview;
    Button btn_add, btn_modify, btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        setListener();
    }
    public void initialize(){
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_modify = (Button) findViewById(R.id.btn_modify);
        btn_delete = (Button) findViewById(R.id.btn_delete);

        items = new ArrayList<String>() ;
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, items) ;
        listview = (ListView) findViewById(R.id.listview1) ;
        listview.setAdapter(adapter) ;
    }
    public void setListener(){
        btn_add.setOnClickListener(this);
        btn_modify.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        int count, checked;
        count = adapter.getCount();

        switch (v.getId()) {
            case R.id.btn_add :
                items.add("LIST" + Integer.toString(count + 1 ));
                break;
            case R.id.btn_modify :
                if( count > 0 ){
                    checked = listview.getCheckedItemPosition();
                    if( checked > -1 && checked < count ) {
                        items.set(checked, Integer.toString(checked + 1) + "번 아이템 수정");
                    }
                }
                break;
            case R.id.btn_delete :
                if( count > 0 ) {
                    checked = listview.getCheckedItemPosition();
                    if( checked > -1 && checked < count ) {
                        items.remove(checked);
                        listview.clearChoices();
                    }
                }
                break;
        }
        adapter.notifyDataSetChanged();
    }
}
