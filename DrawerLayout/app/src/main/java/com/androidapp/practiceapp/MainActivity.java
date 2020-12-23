package com.androidapp.practiceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonOpen, buttonClose;
    CheckBox checkboxLock;
    DrawerLayout drawer;
    ImageView viewLeftOpen, viewRightOpen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    @Override
    public void onClick(View v) {
        if (!checkboxLock.isChecked()) {
            switch (v.getId()) {
                case R.id.btn_open:
                    if (!drawer.isDrawerOpen(Gravity.LEFT)) {
                        drawer.openDrawer(Gravity.LEFT);
                    }
                    break;
                case R.id.btn_close:
                    if (drawer.isDrawerOpen(Gravity.LEFT)) {
                        drawer.closeDrawer(Gravity.LEFT);
                    }
                    break;
            }
        }
    }

    public void init() {
        checkboxLock = (CheckBox) findViewById(R.id.lock) ;
        checkboxLock.setOnClickListener(this);
        drawer = (DrawerLayout) findViewById(R.id.drawer) ;
        buttonOpen = (Button) findViewById(R.id.btn_open) ;
        buttonOpen.setOnClickListener(this);
        buttonClose = (Button) findViewById(R.id.btn_close) ;
        buttonClose.setOnClickListener(this);
        viewLeftOpen = (ImageView) findViewById(R.id.v_left);
        viewRightOpen = (ImageView) findViewById(R.id.v_right);
    }
}
