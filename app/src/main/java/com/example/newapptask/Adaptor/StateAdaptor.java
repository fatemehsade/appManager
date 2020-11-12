package com.example.newapptask.Adaptor;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.newapptask.Cotroller.Fragment.StateFragment;

import java.util.UUID;

public class StateAdaptor extends FragmentStateAdapter {
    private UUID mUserId;

    public StateAdaptor(@NonNull FragmentActivity fragmentActivity, UUID userId)
    {
        super(fragmentActivity);
        mUserId=userId;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return StateFragment.newInstance("TODO",mUserId);
            case 1:
                return StateFragment.newInstance("DOING",mUserId);
            case 2:
                return StateFragment.newInstance("DONE",mUserId);
            default:
                return null;
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
