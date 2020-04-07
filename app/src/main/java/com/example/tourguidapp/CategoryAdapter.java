package com.example.tourguidapp;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context context;

    public CategoryAdapter(Context c, FragmentManager fm) {
        super(fm);
        context = c;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new RestaurantsFragment();
            case 1:
                return new NatureFragment();
            case 2:
                return new AttractionsFragment();
            case 3:
                return new LandmarksFragment();
            default:
                return new RestaurantsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return context.getString(R.string.restaurants_category);
            case 1:
                return context.getString(R.string.nature_category);
            case 2:
                return context.getString(R.string.attractions_category);
            case 3:
                return context.getString(R.string.landmarks_category);
            default:
                return context.getString(R.string.restaurants_category);
        }
    }
}
