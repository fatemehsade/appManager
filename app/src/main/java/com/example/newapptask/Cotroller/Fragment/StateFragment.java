package com.example.newapptask.Cotroller.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newapptask.R;

import java.util.UUID;


public class StateFragment extends Fragment {


    public static final String EXTRA_TAB_NAME = "com.example.newapptask.Cotroller.Fragment.TabName";

    public StateFragment() {
        // Required empty public constructor
    }

    public static StateFragment newInstance(String tabName, UUID userId) {
        StateFragment fragment = new StateFragment();
        Bundle args = new Bundle();
        args.putString(EXTRA_TAB_NAME,tabName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_state, container, false);
    }
}