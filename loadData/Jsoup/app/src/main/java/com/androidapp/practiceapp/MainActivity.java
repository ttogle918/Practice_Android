package com.androidapp.practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    ListView listView;
    ListViewAdapter adapter;
    EditText editText;
    ImageButton searchButton, plusbutton;
    String key = "1f3b13bdaccd44dcbba5b63de44e478f";
    String sigun;

    OpenAPIDistinct distint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        setListener();

    }
    public void initialize() {
        adapter = new ListViewAdapter();
        listView = (ListView) findViewById(R.id.listview1);
        final View header = getLayoutInflater().inflate(R.layout.listview_header, null, false) ;
        listView.addHeaderView(header) ;
        editText = (EditText) header.findViewById(R.id.editText1) ;
        searchButton = (ImageButton)header.findViewById(R.id.searchButton) ;
        plusbutton = (ImageButton)header.findViewById(R.id.imageButton2);
        listView.setAdapter(adapter);
        String url = "http://openapi.gg.go.kr/AnimalPharmacy?KEY=" + key;
        distint = new OpenAPIDistinct(url);
        distint.execute();

    }

    public void setListener() {
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plusbutton.setVisibility(View.VISIBLE);
                adapter = new ListViewAdapter();
                listView.setAdapter(adapter);
                sigun = editText.getText().toString();
                String url = "http://openapi.gg.go.kr/AnimalPharmacy?SIGUN_NM=" + sigun + "&KEY=" + key;
                OpenAPI pharmacy = new OpenAPI(url, adapter);
                pharmacy.execute();
                adapter.notifyDataSetChanged();
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence seq, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence seq, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String filterText = editable.toString();
                /*
                ((ListViewAdapter)listview.getAdapter()).getFilter().filter(filterText) ;
                필터링 텍스트 팝업을 보이지 않게 하고싶다면
                adapter로부터 직접 filter 객체 참조
                 */
                if ( filterText.length() > 0 ){

                    listView.setFilterText(filterText);
                } else {
                    listView.clearTextFilter();
                }
            }
        });
    }
}
