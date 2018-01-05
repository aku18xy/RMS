package com.example.nas.rms;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by nas on 03/01/2018.
 */

public class TabAdapter extends FragmentPagerAdapter {

    public static int item_count = 3;


    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ConfigFragment();
            case 1:
                return new ControllerFragment();
            case 2:
                return new DeployFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return item_count;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Config";
            case 1:
                return "Controller";
            case 2:
                return "Deploy";
            default:
                return null;
        }
    }
}
