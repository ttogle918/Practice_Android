package com.androidapp.lottedelivery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    // data save할 arraylist
    private ArrayList<RecyclerItem> listViewItems = new ArrayList<RecyclerItem>();

    public ListViewAdapter() {
    }

    public void addItem(String title, String addr, String area, int code, String amount) {
        RecyclerItem item = new RecyclerItem();

        item.setNameStr(title);
        item.setAddrStr(addr);
        item.setAddrStr(area);
        item.setAreaCode(code);
        item.setAmount(amount);

        listViewItems.add(item);
    }
    @Override
    public int getCount() {
        return listViewItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItems.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.destination_list_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView nameView = (TextView) convertView.findViewById(R.id.name) ;
        TextView addressView = (TextView) convertView.findViewById(R.id.address) ;
        TextView areaView = (TextView) convertView.findViewById(R.id.areaCode) ;
        TextView amountView = (TextView) convertView.findViewById(R.id.amount) ;

        TextView t_startView = (TextView) convertView.findViewById(R.id.t_start) ;
        TextView t_endView = (TextView) convertView.findViewById(R.id.t_end) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        RecyclerItem listViewItem = listViewItems.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        nameView.setText(listViewItem.getNameStr());
        addressView.setText(listViewItem.getAddrStr());
        areaView.setText(listViewItem.getAreaStr() + "|"+ listViewItem.getAreaCode());
        amountView.setText(listViewItem.getAmount() + "PLT");
        t_startView.setText(listViewItem.getT_start());
        t_endView.setText(listViewItem.getT_end());

        return convertView;
    }
}
