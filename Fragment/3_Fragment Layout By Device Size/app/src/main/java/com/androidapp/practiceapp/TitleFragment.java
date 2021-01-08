package com.androidapp.practiceapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

public class TitleFragment extends ListFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        showDetails(position);
    }
    public interface OnTitleSelectedListener {
        public void onTitleSelected(int position) ;
    }
    OnTitleSelectedListener titleSelectedListener;

    public void showDetails(int position) {
        titleSelectedListener.onTitleSelected(position) ;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            if (context instanceof Activity) {
                titleSelectedListener = (OnTitleSelectedListener) context;
            }
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnTitleSelectedListener");
        }
    }
}
