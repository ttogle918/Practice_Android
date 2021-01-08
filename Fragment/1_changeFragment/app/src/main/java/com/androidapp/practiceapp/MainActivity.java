package com.androidapp.practiceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
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

import com.androidapp.practiceapp.Fragment.FragmentB;
import com.androidapp.practiceapp.Fragment.FragmentC;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private boolean isFragmentB = true;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        setListener();
    }
    public void initialize() {
        button = (Button) findViewById(R.id.button1);

        FragmentManager fm = getSupportFragmentManager();                   // manager의 reference 획득
        FragmentTransaction fragmentTransaction = fm.beginTransaction();    // 시작
        fragmentTransaction.add(R.id.fragmentBorC, new FragmentB());        // ViewGroup에 추가
        fragmentTransaction.commit();       // 작업 완료 알려줌

    }

    public void setListener() {
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchFragment();
            }
        });
    }
    public void switchFragment() {
        Fragment fr;

        if (isFragmentB) {
            fr = new FragmentB();
        } else {
            fr = new FragmentC();
        }

        isFragmentB = (isFragmentB) ? false : true ;    // change

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentBorC, fr);
        fragmentTransaction.commit();
    }
}
