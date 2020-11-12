package com.example.newapptask.Cotroller.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.newapptask.Cotroller.Activity.LoginActivity;
import com.example.newapptask.Model.User;
import com.example.newapptask.R;
import com.example.newapptask.Repository.UserDBRepository;


public class SignFragment extends Fragment {

    private EditText mEditText_userName;
    private EditText mEditText_password;
    private Button mButton_signUp;
    private UserDBRepository mRepository;
    private User mUser=new User();



    public SignFragment() {
        // Required empty public constructor
    }


    public static SignFragment newInstance() {
        SignFragment fragment = new SignFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRepository=UserDBRepository.getInstance(getContext());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sign, container, false);
        findViews(view);
        setListener();
        return view;
    }

    private void findViews(View view) {
        mEditText_userName=view.findViewById(R.id.edit_text_user_sign);
        mEditText_password=view.findViewById(R.id.edit_text_password_sign);
        mButton_signUp=view.findViewById(R.id.btn_signup_sign);
    }
    private void setListener(){
        mButton_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mEditText_userName.getText().toString().equals("")&&
                        !mEditText_password.getText().toString().equals("")) {
                    if (!mRepository.userExist(mEditText_userName.toString())) {
                        mUser.setUserName(mEditText_userName.getText().toString());
                        mUser.setPassword(mEditText_password.getText().toString());
                        mRepository.insert(mUser);
                        LoginActivity.start(getContext());
                    } else {
                        toastMetod("user exist");
                    }
                }else {
                    toastMetod("user name or pass word is null");
                }

            }
        });
    }
    private void toastMetod(String text){
        Toast.makeText(getActivity(),text,Toast.LENGTH_LONG).show();
    }
}