package com.example.newapptask.Cotroller.Activity;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.example.newapptask.Cotroller.Fragment.LoginFragment;
import com.example.newapptask.SingleFragmentActivity;

public class LoginActivity extends SingleFragmentActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, LoginActivity.class);
        context.startActivity(starter);
    }

    @Override
    public Fragment createFragment() {
        return new LoginFragment();
    }
}