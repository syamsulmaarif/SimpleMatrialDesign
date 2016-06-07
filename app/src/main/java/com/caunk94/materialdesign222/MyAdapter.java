package com.caunk94.materialdesign222;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

/**
 * Created by ilham-hp on 9/6/2015.
 */
public class MyAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String[] titles = {"A", "B", "C"};
    int[] icons = new int[]{
            R.mipmap.ic_meong,
            R.drawable.ic_thumb_up_black_48dp,
            R.drawable.ic_settings_system_daydream_black_48dp};
    private int heightIcon;

    public MyAdapter(FragmentManager fm, Context c) {
        super(fm);

        mContext = c;
        double scale=c.getResources().getDisplayMetrics().density;
        heightIcon=(int)(24*scale+0.5f);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;

        if (position == 0) {
            frag = new RecyclerViewFragment();
        } else if (position == 1) {
            frag = new FragmentDua();
        } else if (position == 2) {
            frag = new FragmentTiga();
        }

        Bundle b = new Bundle();
        b.putInt("position", position);

        frag.setArguments(b);
        return frag;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Drawable d = mContext.getResources().getDrawable(icons[position]);
        d.setBounds(0,0,heightIcon,heightIcon);

        ImageSpan is = new ImageSpan(d);

        SpannableString sp = new SpannableString(" ");
        sp.setSpan(is,0,sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //return (titles[position]);
        return (sp);
    }
}
