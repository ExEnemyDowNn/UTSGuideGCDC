package com.example.utsezzaguidegcdc.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.utsezzaguidegcdc.ElesisPvE;
import com.example.utsezzaguidegcdc.ElesisPvP;
import com.example.utsezzaguidegcdc.LimePvE;
import com.example.utsezzaguidegcdc.LimePvP;
import com.example.utsezzaguidegcdc.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter3 extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.PvE, R.string.PvP};
    private final Context mContext;

    public SectionsPagerAdapter3(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new LimePvE();
                break;

            case 1:
                fragment = new LimePvP();
                break;

        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}