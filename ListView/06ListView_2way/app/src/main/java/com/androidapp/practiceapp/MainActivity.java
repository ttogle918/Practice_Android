package com.androidapp.practiceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {
    ListViewAdapter adapter;
    ListView listview;

    Button btn_add, btn_modify, btn_delete;
    View header, footer;
    TextView tv_count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        setListener();
    }
    public void initialize(){
        header = getLayoutInflater().inflate(R.layout.listview_header, null, false);
        tv_count = (TextView) header.findViewById(R.id.count);
        footer = getLayoutInflater().inflate(R.layout.listview_footer, null, false);
        listview = (ListView) findViewById(R.id.listview1) ;

        listview.addHeaderView(header);
        listview.addFooterView(footer);

        btn_add = (Button) findViewById(R.id.btn_add);
        btn_modify = (Button) findViewById(R.id.btn_modify);
        btn_delete = (Button) findViewById(R.id.btn_delete);


        adapter = new ListViewAdapter();
        listview.setAdapter(adapter) ;

        adapter.addItem("The First Item", "this is the first item. 2 TextView are used for title and desc");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile_man_128px), "2nd : Account Box Black 36dp") ;
        adapter.addItem("The Third Item", "this is the third item. Two TextView are used for title and desc.") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile_woman_128px), "4th : Account Circle Black 36dp") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile_basic_128px), "5th : Assignment Ind Black 36dp") ;

        int count = adapter.getCount();
        tv_count.setText(Integer.toString(count+1));
    }
    public void setListener(){
        btn_add.setOnClickListener(this);
        btn_modify.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        SparseBooleanArray checkedItems = listview.getCheckedItemPositions();
        int count, checked;

        count = adapter.getCount();
        switch (v.getId()) {
            case R.id.btn_add :
                adapter.addItem("Add" + Integer.toString(count+1)+"", "clicked add");

                tv_count.setText(Integer.toString(count+1));
                break;
            case R.id.btn_modify :
                if( count > 0 ){
                    checked = listview.getCheckedItemPosition();
                    if( checked > 0 && checked <= count ) {
                        adapter.modifyItem(checked);
                    }
                }
                break;
            case R.id.btn_delete :
                if( count > 0 ) {
                    for (int i = count -1; i >= 0; i--) {
                        if (checkedItems.get(i)) {
                            adapter.removeItem(i);
                        }
                    }
                    tv_count.setText(Integer.toString(count-1));
                    listview.clearChoices();
                }
                break;
        }
        adapter.notifyDataSetChanged();
    }
}
