package com.example.newapptask.Cotroller.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.newapptask.Cotroller.Activity.SignActivity;
import com.example.newapptask.Cotroller.Activity.TaskManagerActivity;
import com.example.newapptask.Model.User;
import com.example.newapptask.R;
import com.example.newapptask.Repository.UserDBRepository;


public class LoginFragment extends Fragment {


    private EditText mEditText_userName;
    private EditText mEditText_password;
    private Button mButton_login;
    private Button mButton_signUp;
    private UserDBRepository mRepository;
    private User mUser;


    public LoginFragment() {
        // Required empty public constructor
    }


    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRepository = UserDBRepository.getInstance(getContext());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        findViews(view);
        setListener();
        return view;
    }

    private void findViews(View view) {
        mEditText_userName = view.findViewById(R.id.username_login);
        mEditText_password = view.findViewById(R.id.password_login);
        mButton_login = view.findViewById(R.id.btn_login_login);
        mButton_signUp = view.findViewById(R.id.btn_signUp_login);
    }

    private void setListener() {
        mButton_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRepository.userExist(mEditText_userName.getText().toString())) {
                    mUser = mRepository.get(mEditText_userName.getText().toString());
                    if (mEditText_password.getText().toString().equals(mUser.getPassword())) {
                        toastMetod("login");
                        Intent intent = TaskManagerActivity.newIntent(getContext());
                        startActivity(intent);


                    }
                    ;//why use muser insted password

                } else
                    toastMetod("At first Sign Up");

            }


        });
        mButton_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "signup", Toast.LENGTH_LONG).show();
                Intent intent = SignActivity.newIntent(getActivity());
                startActivity(intent);

            }
        });
    }

    private void toastMetod(String text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_LONG).show();
        ;
    }
}
