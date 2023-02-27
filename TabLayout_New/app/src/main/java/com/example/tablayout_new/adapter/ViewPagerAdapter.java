package com.example.tablayout_new.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tablayout_new.fragment.ClockFragment;
import com.example.tablayout_new.fragment.LoginFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position==0){
            return ClockFragment.newInstance();
        }
        return LoginFragment.newInstance();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
