package com.example.newapptask.Cotroller.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.newapptask.Cotroller.Fragment.TaskManagerFragment;
import com.example.newapptask.R;
import com.example.newapptask.SingleFragmentActivity;

import java.util.UUID;

public class TaskManagerActivity extends SingleFragmentActivity {
    public static final String EXTRA_USER_ID = "com.example.newapptask.Cotroller.Activity.UserId";
    private UUID mUserId;

    public static Intent newIntent(Context context, UUID userId) {
        Intent intent = new Intent(context, TaskManagerActivity.class);
        intent.putExtra(EXTRA_USER_ID,userId);
        return intent;
    }


    @Override
    public Fragment createFragment() {
        Intent intent=getIntent();
        mUserId= (UUID) intent.getSerializableExtra(EXTRA_USER_ID);

        return TaskManagerFragment.newInstance(mUserId);
    }
}