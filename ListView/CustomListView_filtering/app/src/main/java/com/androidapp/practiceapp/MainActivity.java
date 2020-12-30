package com.androidapp.practiceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    EditText editTextFilter;
    ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }
    public void initialize(){
        adapter = new ListViewAdapter();
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile_man_128px),
                "Sam Smith", "I'm not the only one.\r\nStay with me.\r\n") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile_woman_128px),
                "Bryan Adams", "heaven.\r\nI do it for you.") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile_basic_128px),
                "Eric Clapton", "Tears in heaven.\r\nChange the world.") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile_woman_128px),
                "Gary Moore", "Still got the blues.\r\nOne day.") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile_man_128px),
                "Helloween", "A tale that wasn't right.\r\nI want out.") ;

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile_basic_128px),
                "Adele", "Hello.\r\nSomeone like you.") ;


        editTextFilter = (EditText) findViewById(R.id.editTextFilter);
        editTextFilter.addTextChangedListener(new TextWatcher() {
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
                    listview.setFilterText(filterText);
                } else {
                    listview.clearTextFilter();
                }
            }
        });
    }
}
