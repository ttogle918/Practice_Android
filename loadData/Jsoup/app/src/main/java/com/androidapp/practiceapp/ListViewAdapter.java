package com.androidapp.practiceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>() ;

    public ListViewAdapter() {
    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageButton imageButton = (ImageButton) convertView.findViewById(R.id.imageButton) ;
        TextView nameView = (TextView) convertView.findViewById(R.id.tv_name) ;
        TextView addrView = (TextView) convertView.findViewById(R.id.tv_addr) ;
        TextView addrNumView = (TextView) convertView.findViewById(R.id.tv_addrNum) ;
        TextView numberView = (TextView) convertView.findViewById(R.id.tv_phoneNum) ;


        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ListViewItem listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        nameView.setText(listViewItem.getName());
        addrView.setText(listViewItem.getAddr());
        addrNumView.setText(listViewItem.getAddrNum());
        numberView.setText(listViewItem.getNumberStr());

        return convertView;
    }

    public void addItem(String name, String number, String addr, String addrNum) {
        ListViewItem item = new ListViewItem();

        item.setName(name);
        item.setNumber(number);
        item.setAddr(addr);
        item.setAddrNum(addrNum);

        listViewItemList.add(item);
    }

}
