package com.example.newapptask.Cotroller.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newapptask.Adaptor.StateAdaptor;
import com.example.newapptask.Model.User;
import com.example.newapptask.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TaskManagerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TaskManagerFragment extends Fragment {

    public static final String EXTRA_USER_ID = "UserId";
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager;
    public static final String TODO_FRAGMENT = "TODO";
    public static final String DOING_FRAGMENT = "DOING";
    public static final String DONE_FRAGMENT = "DONE";
    public static final String EXTRA_TAB_NAME = "Tab_name";
    private UUID mUserId;
    private StateAdaptor mAdaptor;




    public TaskManagerFragment() {
        // Required empty public constructor
    }


    public static TaskManagerFragment newInstance(UUID userId) {
        TaskManagerFragment fragment = new TaskManagerFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_USER_ID,userId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserId= (UUID) getArguments().get(EXTRA_USER_ID);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_task_manager, container, false);
        findViews(view);
        setUpAdaptor();
        return view;
    }

    private void setUpAdaptor() {
        mAdaptor=new StateAdaptor(getActivity(),mUserId);
        mViewPager.setAdapter(mAdaptor);
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
    }

    private void findViews(View view) {
        mTabLayout=view.findViewById(R.id.tabLayout);
        mViewPager=view.findViewById(R.id.viewPager);
    }
}