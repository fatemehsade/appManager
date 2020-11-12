package com.example.newapptask.Cotroller.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newapptask.Adaptor.StateAdaptor;
import com.example.newapptask.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TaskManagerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TaskManagerFragment extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager2 mViewPager;
    public static final String TODO_FRAGMENT = "TODO";
    public static final String DOING_FRAGMENT = "DOING";
    public static final String DONE_FRAGMENT = "DONE";
    public static final String EXTRA_TAB_NAME = "Tab_name";



    public TaskManagerFragment() {
        // Required empty public constructor
    }


    public static TaskManagerFragment newInstance() {
        TaskManagerFragment fragment = new TaskManagerFragment();
        Bundle args = new Bundle();

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
        View view= inflater.inflate(R.layout.fragment_task_manager, container, false);
        findViews(view);
        view = inflater.inflate(R.layout.fragment_task_manager, container, false);
        mViewPager.setAdapter(new StateAdaptor(getActivity()));
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(mTabLayout, mViewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText(TODO_FRAGMENT);
                            break;
                        case 1:
                            tab.setText(DOING_FRAGMENT);

                            break;
                        case 2:
                            tab.setText(DONE_FRAGMENT);

                            break;
                    }

                });
        tabLayoutMediator.attach();

        return view;
    }

    private void findViews(View view) {
        mTabLayout=view.findViewById(R.id.tabLayout);
        mViewPager=view.findViewById(R.id.viewPager);
    }
}