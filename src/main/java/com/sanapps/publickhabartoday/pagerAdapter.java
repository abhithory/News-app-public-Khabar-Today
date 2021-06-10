package com.sanapps.publickhabartoday;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class pagerAdapter extends FragmentStateAdapter {
    public pagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                bhadraFragment fm1 = new bhadraFragment();
                return fm1;
            case 2:
                rajasthanFragment fm2 = new rajasthanFragment();
                return fm2;
            case 3:
                indiaFragment fm3 = new indiaFragment();
                return fm3;
            case 4:
                haryanaFragment fm4 = new haryanaFragment();
                return fm4;
            case 5:
                worldFragment fm5 = new worldFragment();
                return fm5;

            default:
                return new allNewsFragment();

        }
    }


        @Override
        public int getItemCount () {
            return 6;
        }
    }
