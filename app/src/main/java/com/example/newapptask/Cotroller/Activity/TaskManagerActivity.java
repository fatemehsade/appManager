package com.example.newapptask.Cotroller.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.newapptask.Cotroller.Fragment.TaskManagerFragment;
import com.example.newapptask.R;
import com.example.newapptask.SingleFragmentActivity;

public class TaskManagerActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, TaskManagerActivity.class);
        return intent;
    }


    @Override
    public Fragment createFragment() {
        return new TaskManagerFragment();
    }
}