package com.androidapp.practiceapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    private static final int ITEM_VIEW_TYPE_STRS = 0;
    private static final int ITEM_VIEW_TYPE_IMGS = 1;
    private static final int ITEM_VIEW_TYPE_MAX = 2;
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>() ;

    public ListViewAdapter() {

    }


    @Override
    public int getCount(){
        return listViewItemList.size();
    }

    @Override
    public int getViewTypeCount() {
        return ITEM_VIEW_TYPE_MAX;
    }

    @Override
    public int getItemViewType(int position) {
        return listViewItemList.get(position).getType();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final Context context = parent.getContext();
        int viewType = getItemViewType(position);

        if( convertView == null ) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            ListViewItem listViewItem = listViewItemList.get(position);

            switch (viewType) {
                case ITEM_VIEW_TYPE_STRS :
                    convertView = inflater.inflate(R.layout.listview_item1, parent, false);
                    TextView titleTextView = (TextView) convertView.findViewById(R.id.title);
                    TextView descTextView = (TextView) convertView.findViewById(R.id.desc);

                    titleTextView.setText(listViewItem.getTitleStr());
                    descTextView.setText(listViewItem.getDescStr());
                    break;
                case ITEM_VIEW_TYPE_IMGS :
                    convertView = inflater.inflate(R.layout.listview_item2, parent, false);
                    ImageView iconImageView = (ImageView) convertView.findViewById(R.id.image);
                    TextView nameTextView = (TextView) convertView.findViewById(R.id.name);

                    iconImageView.setImageDrawable(listViewItem.getIconDrawable());
                    nameTextView.setText(listViewItem.getNameStr());
                    break;
            }
        }
        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addItem(String title, String desc) {
        ListViewItem item = new ListViewItem();
        item.setType(ITEM_VIEW_TYPE_STRS);
        item.setTitleStr(title);
        item.setDescStr(desc);

        listViewItemList.add(item);
    }

    public void addItem(Drawable icon, String name) {
        ListViewItem item = new ListViewItem();
        item.setType(ITEM_VIEW_TYPE_IMGS);
        item.setIconDrawable(icon);
        item.setNameStr(name);

        listViewItemList.add(item);
    }

    public void removeItem(int position) {
        listViewItemList.remove(position);
    }

    public void modifyItem(int position){
        ListViewItem item = new ListViewItem();
        item.setType(ITEM_VIEW_TYPE_STRS);
        item.setTitleStr(position + "번 수정");
        item.setDescStr(position + "번 수정되었습니다.");
        listViewItemList.set(position-1, item);
    }
}
