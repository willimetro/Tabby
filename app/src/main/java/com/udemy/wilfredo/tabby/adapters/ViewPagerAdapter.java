package com.udemy.wilfredo.tabby.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.udemy.wilfredo.tabby.activities.TabbyActivity;
import com.udemy.wilfredo.tabby.fragments.FormFragment;
import com.udemy.wilfredo.tabby.fragments.ListFragment;

/**
 * Adaptador para el ViewPager
 * Created by wilfredo on 24-02-18.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private int numberTabs;

    public ViewPagerAdapter(FragmentManager fm, int numberTabs) {
        super(fm);
        this.numberTabs = numberTabs;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case TabbyActivity.PERSON_FORM_FRAGMENT:
                fragment = new FormFragment();
                break;
            case TabbyActivity.PERSON_LIST_FRAGMENT:
                fragment = new ListFragment();
                break;
            default:
                fragment = null;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return numberTabs;
    }
}
