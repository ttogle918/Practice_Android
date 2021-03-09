package com.androidapp.lottedelivery;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemListActivity extends AppCompatActivity {

    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerView mRecyclerView = null;
    RecyclerAdapter adapter = null;
    ArrayList<RecyclerItem> mList = new ArrayList<RecyclerItem>();
    Intent intent;
    Button btn_finish;
    private ArrayList<RecyclerView.ViewHolder> mholder = new ArrayList<RecyclerView.ViewHolder>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_shop);
        init();
        setListener();
    }

    public void setListener() {
        adapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position, Bundle bundle) {
                Intent intent1 = new Intent(ItemListActivity.this, ItemInfoActivity.class);
                intent1.putExtra("myBundle", bundle);
                startActivityForResult(intent1, 1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode != RESULT_OK) {
            finish();
        }
        Bundle bundle = intent.getBundleExtra("bundle");
        this.intent.putExtra("activity", "ItemListActivity");
    }

    public void init() {
        btn_finish = (Button) findViewById(R.id.finish);
        mRecyclerView = findViewById(R.id.recyclerView);

        intent = getIntent();

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        adapter = new RecyclerAdapter(mList, mholder);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        adapter.addItem("공룡도배부른안심탕수육 면목점", "서울특별시 중랑구 중랑천로 64 (면목동)", "성동지점", 036, "0.145");
        adapter.addItem("구상짜글이", "서울특별시 중랑구 중랑천로 37 (면목동, 신성아파트) 상가동", "성동지점", 036, "0.163");
        adapter.addItem("꼬망세피자", "서울특별시 중랑구 중랑천로 20", "성동지점", 036, "1.10");
        adapter.notifyDataSetChanged();

        adapter.setPosition();
    }
}
