package com.androidapp.practiceapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.ListFragment;


public class CustomListFragment extends ListFragment {
    ListViewAdapter adapter;

    public CustomListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        adapter = new ListViewAdapter();
        setListAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.profile_basic_128px), "basic", "Profile Basic");
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.profile_man_128px), "man", "Profile Man");
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.profile_woman_128px), "woman", "Profile Woman");

        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // get TextView's Text.
        ListViewItem item = (ListViewItem) l.getItemAtPosition(position) ;

        String titleStr = item.getTitle() ;
        String descStr = item.getDesc() ;
        Drawable iconDrawable = item.getIcon() ;
    }

    public void addItem(Drawable icon, String title, String desc) {
        adapter.addItem(icon, title, desc);
    }
}
