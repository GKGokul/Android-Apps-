package com.example.android.miwok;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * Created by gk on 5/30/17.
 */

public class FragPagerAdapter extends FragmentPagerAdapter {

public FragPagerAdapter(FragmentManager fm){ super(fm); }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NumbersFragment();
        } else if (position == 1){
            return new FamilyFragment();
        } else if(position ==2){
            return new ColorsFragment();
        } else{
            return new PhrasesFragment();
        }

    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position ==0){
            return "Numbers";
        }
        else if(position ==1){
            return "Family Members";
        }
        else if(position ==2){
            return "Colors";
        }
        else{
            return "Phrases";
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
