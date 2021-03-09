package com.androidapp.lottedelivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView button;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setListener();

        String activity = PreferenceManager.getString(this, "activity");
        boolean login = PreferenceManager.getBoolean(this, "isLogin");
        Log.d("preference", "onCreate: preference check");
        if ( login == false ) {
            Log.d("login", "onCreate: false check");

            Intent intent = new Intent(MainActivity.this, LoginActivity.class) ;
            startActivityForResult(intent, RESULT_OK);
        }

        if (!activity.equals("")) {
            Log.d("activity", "onCreate:  not null");

            checkActivity(activity);
        }
    }
    public void checkActivity( String activity ){
        if (activity.equals("ItemInfo")) {
            Log.d("activity", " : itmeinfo");
            Intent intent = new Intent(MainActivity.this, ItemInfoActivity.class);
            startActivityForResult(intent, RESULT_OK);
            Log.d("activity", " : itmeinfo");

        } else if (activity.equals("ItemList")) {
            Log.d("activity", " : itemList");
            Intent intent = new Intent(MainActivity.this, ItemListActivity.class);
            startActivityForResult(intent, RESULT_OK);
            Log.d("activity", " : itemList");

        } else {
        }
    }
    public void setListener(){
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ItemListActivity.class) ;
                startActivity(intent);
            }
        });
    }
    public void init() {
        button = findViewById(R.id.btn_start);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        //super.startActivityForResult(intent, requestCode);
        if (resultCode != RESULT_OK ) {
            return;
        }


        String activity = intent.getStringExtra("activity");
        Bundle bundle = intent.getBundleExtra("bundle");

        if (activity.equals("loginActivity")) {
            //user = (User)(bundle.get("user"));
            PreferenceManager.setBoolean(this, "isLogin", true);
            Log.d("activity", "onCreate:  not null");

        } else if (activity.equals("ItemListActivity")) {

        } else if (activity.equals("ItemInfoActivity")) {

        }
    }
}
