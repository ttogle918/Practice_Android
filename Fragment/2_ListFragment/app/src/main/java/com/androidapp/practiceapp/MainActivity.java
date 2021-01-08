package com.androidapp.practiceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.androidapp.practiceapp.Fragment.CustomListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }
    public void initialize() {
        CustomListFragment customListFrgmt = (CustomListFragment) getSupportFragmentManager().findFragmentById(R.id.menulistfragment);
        customListFrgmt.addItem(ContextCompat.getDrawable(this, R.drawable.profile_basic_128px),
                "New Profile", "New") ;
    }
}
