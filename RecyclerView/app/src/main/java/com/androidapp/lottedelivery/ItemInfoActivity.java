package com.androidapp.lottedelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

public class ItemInfoActivity extends AppCompatActivity {
    TabLayout tabLayout;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_tab);
        Intent intent = getIntent();

        tabLayout = (TabLayout) findViewById(R.id.tabs) ;
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition() ;
                changeView(pos) ;
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // do nothing
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // do nothing
            }
        }) ;

    }
    private void changeView(int index) {
        LinearLayout layout1 = (LinearLayout) findViewById(R.id.layout1) ;
        LinearLayout layout2 = (LinearLayout) findViewById(R.id.layout2) ;

        switch (index) {
            case 0 :
                layout1.setVisibility(View.VISIBLE) ;
                layout2.setVisibility(View.INVISIBLE) ;
                setTextInfo(intent);
                break ;
            case 1 :
                layout1.setVisibility(View.INVISIBLE) ;
                layout2.setVisibility(View.VISIBLE) ;
                break ;
        }
    }

    private void setTextInfo(Intent intent) {
        TextView order_num = (TextView) findViewById(R.id.order_num) ;
        TextView shop_code = (TextView) findViewById(R.id.shop_code) ;
        TextView shop_name = (TextView) findViewById(R.id.shop_name) ;
        TextView channel_code = (TextView) findViewById(R.id.channel_code) ;
        TextView biz_num = (TextView) findViewById(R.id.biz_num) ;
        TextView shop_addr = (TextView) findViewById(R.id.shop_addr) ;
        TextView shop_memo = (TextView) findViewById(R.id.shop_memo) ;
        TextView center_manager = (TextView) findViewById(R.id.center_manager) ;
        TextView ps = (TextView) findViewById(R.id.ps) ;
        TextView shop_manager = (TextView) findViewById(R.id.shop_manager) ;

        Bundle bundle = intent.getBundleExtra("myBundle");
        int count = bundle.getInt("count", 0);
        shop_name.setText(bundle.getString("name", ""));
        shop_addr.setText(bundle.getString("addr", ""));
        bundle.getString("area", "");
        bundle.getInt("areacode", -1);
        bundle.getString("amount", "");
    }
}
