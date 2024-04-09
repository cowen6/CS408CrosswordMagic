package edu.jsu.mcis.cs408.crosswordmagic.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabLayoutAdapter extends FragmentStateAdapter {

    public static final int NUM_TABS = 2;

    public TabLayoutAdapter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Fragment fragment;

        if (position == 0) {
            fragment = new PuzzleFragment();
        }
        else {
            fragment = new ClueFragment();
        }

        return fragment;

    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }

}