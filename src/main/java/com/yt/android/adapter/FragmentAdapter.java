package com.yt.android.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Fragment适配器
 *
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.adapter
 * @date 2016/4/8 0008 17:14
 * @descption: 疯狂的王麻子团队!
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;


    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public FragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
