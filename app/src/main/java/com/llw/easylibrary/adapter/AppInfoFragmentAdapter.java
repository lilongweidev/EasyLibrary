package com.llw.easylibrary.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * GoodsFragment适配器
 *
 * @author llw
 * @date 2021/4/29 10:56
 */
public class AppInfoFragmentAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;
    private ArrayList<String> tabName;

    public AppInfoFragmentAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String>
            tabName) {
        super(fm);
        this.fragments = fragments;
        this.tabName = tabName;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabName.get(position);
    }
}