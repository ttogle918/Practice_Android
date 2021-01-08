package com.androidapp.practiceapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_fragment, container, false);
        super.onCreateView(inflater, container, savedInstanceState);

        Bundle args = getArguments() ;

        TextView titleTextView = (TextView) view.findViewById(R.id.selectedTitle) ;
        titleTextView.setText(args.getString("title")) ;

        TextView detailsTextView = (TextView) view.findViewById(R.id.detailsText) ;
        detailsTextView.setText(args.getString("details")) ;

        return view ;
    }
}
