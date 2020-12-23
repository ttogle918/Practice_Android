package com.androidapp.practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageButton buttonUp, buttondown;
    ScrollView scrollView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setListener();

        String text = "";
        for(int i = 0; i < 100; i++)
            text += i + "\n";
        textView.setText(text);
    }
    public void setListener(){
        View.OnClickListener Listener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch ( v.getId() ) {
                    case R.id.imageButton_up :
                        scrollView.fullScroll(ScrollView.FOCUS_UP);
                        break;
                    case R.id.imageButton_down :
                        scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                        break;
                }
            }
        };

        buttonUp.setOnClickListener(Listener);
        buttondown.setOnClickListener(Listener);
    }

    public void init() {
        scrollView = (ScrollView)findViewById(R.id.scroll_view);
        buttonUp = (ImageButton)findViewById(R.id.imageButton_up);
        buttondown = (ImageButton)findViewById(R.id.imageButton_down);
        textView = (TextView)findViewById(R.id.textView);
    }
}
