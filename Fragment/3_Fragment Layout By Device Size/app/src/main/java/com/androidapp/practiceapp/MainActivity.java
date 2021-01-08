package com.androidapp.practiceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TitleFragment.OnTitleSelectedListener {
    final String[][] contents = new String[3][2] ;
    ArrayAdapter adapter;
    TitleFragment titlesFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        contents[0][0] = "TITLE-1" ;
        contents[0][1] = "This is Details of TITLE-1." ;
        contents[1][0] = "TITLE-2" ;
        contents[1][1] = "This is Details of TITLE-2." ;
        contents[2][0] = "TITLE-3" ;
        contents[2][1] = "This is Details of TITLE-3." ;

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, new ArrayList()) ;
        adapter.add(contents[0][0]);
        adapter.add(contents[1][0]);
        adapter.add(contents[2][0]);

        titlesFragment = (TitleFragment) getSupportFragmentManager().findFragmentById(R.id.title_fragment);
        titlesFragment.setListAdapter(adapter);

        if (getResources().getConfiguration().isLayoutSizeAtLeast(Configuration.SCREENLAYOUT_SIZE_LARGE) &&
                getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            DetailFragment fr = new DetailFragment();
            Bundle args = new Bundle() ;

            args.putString("title", contents[0][0]);
            args.putString("details", contents[0][1]);
            fr.setArguments(args) ;

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.details_container, fr);
            fragmentTransaction.commit();
        }
    }
    public void initialize() {

    }
    @Override
    public void onTitleSelected(int position)
    {
        if (getResources().getConfiguration().isLayoutSizeAtLeast(Configuration.SCREENLAYOUT_SIZE_LARGE) &&
                getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            DetailFragment fr = new DetailFragment();
            Bundle args = new Bundle() ;

            args.putString("title", contents[position][0]);
            args.putString("details", contents[position][1]);
            fr.setArguments(args) ;

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.details_container, fr);
            fragmentTransaction.commit();
        } else {
            Intent intent = new Intent();
            intent.setClass(this, DetailActivity.class);

            intent.putExtra("title", contents[position][0]);
            intent.putExtra("details", contents[position][1]);

            startActivity(intent);
        }
    }
}
