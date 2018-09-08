package com.example.dpolania.demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {

    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private ThirdFragment thirdFragment;

    public MyPagerAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if (firstFragment == null) {
                    firstFragment = new FirstFragment ();
                }
                return firstFragment;
            case 1:
                if (secondFragment == null) {
                    secondFragment = new SecondFragment();
                }
                return secondFragment;
            case 2:
                if (thirdFragment == null) {
                    thirdFragment = new ThirdFragment();
                }
                return thirdFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "tab 1";
        } else if (position == 1) {
            return "tab 2";
        }else if (position == 2) {
            return "tab 3";
        }
        return "";
    }
}
