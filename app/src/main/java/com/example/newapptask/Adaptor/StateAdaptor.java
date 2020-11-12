package com.example.newapptask.Adaptor;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.newapptask.Cotroller.Fragment.StateFragment;

public class StateAdaptor extends FragmentStateAdapter {

    public StateAdaptor(@NonNull FragmentActivity fragmentActivity)
    {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new StateFragment();
            case 1:
                return new StateFragment();
            case 2:
                return new StateFragment();
            default:
                return null;
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
