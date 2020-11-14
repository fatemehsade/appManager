package com.example.newapptask.Cotroller.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newapptask.Adaptor.stateAdaptor;
import com.example.newapptask.AddDialog;
import com.example.newapptask.R;
import com.example.newapptask.Repository.TaskDBRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.UUID;


public class StateFragment extends Fragment {

    public static final String ExtraUSER_ID = "UserId";
    public static final String EXTRA_USER_ID = ExtraUSER_ID;
    public static final int REQUEST_CODE_ADD_DIALOG = 1;
    public static final int REQUEST_CODE_ADD_TASK = REQUEST_CODE_ADD_DIALOG;
    public static final String SHOW_TASK = "showTask";
    private RecyclerView mRecyclerView;
    private FloatingActionButton fab;
    private stateAdaptor mAdaptor;
    private TaskDBRepository mRepository;
    private UUID mUserId;
    private String mTabName;
    public static final String EXTRA_TAB_NAME = "com.example.newapptask.Cotroller.Fragment.TabName";

    public StateFragment() {
        // Required empty public constructor
    }

    public static StateFragment newInstance(String tabName, UUID userId) {
        StateFragment fragment = new StateFragment();
        Bundle args = new Bundle();
        args.putString(EXTRA_TAB_NAME,tabName);
        args.putSerializable(EXTRA_USER_ID,userId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRepository=TaskDBRepository.getInstance(getContext());
        mUserId= (UUID) getArguments().get(EXTRA_USER_ID);
        mTabName= (String) getArguments().get(EXTRA_TAB_NAME);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_state, container, false);
        findViews(view);
        setListener();
        setUpAdaptor();
        return view;
    }

    private void findViews(View view) {
        mRecyclerView=view.findViewById(R.id.recycler_view);
        fab=view.findViewById(R.id.btn_fab);
    }
    private void setListener(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDialog addDialog=AddDialog.newInstance(mTabName,mUserId);
                addDialog.setTargetFragment(StateFragment.this, REQUEST_CODE_ADD_TASK);
                addDialog.show(getActivity().getSupportFragmentManager(), SHOW_TASK);


            }
        });
    }
    private void setUpAdaptor(){
        mAdaptor=new stateAdaptor(mRepository.getListWithUserId(mUserId), getContext(),
                new stateAdaptor.onIconSelectListener() {
            @Override
            public void OnaSelectShowBtn(UUID taskId) {
                showDialogFragment dialogFragment=showDialogFragment.newInstance(taskId);
                dialogFragment.show(getFragmentManager(),SHOW_TASK);
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdaptor);

    }
}