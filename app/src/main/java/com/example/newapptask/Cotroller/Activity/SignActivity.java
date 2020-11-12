package com.example.newapptask.Cotroller.Activity;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.example.newapptask.Cotroller.Fragment.SignFragment;
import com.example.newapptask.SingleFragmentActivity;

public class SignActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context context){
        Intent intent=new Intent(context, SignActivity.class);
        return intent;
    }


    @Override
    public Fragment createFragment() {
        return new SignFragment();
    }
}