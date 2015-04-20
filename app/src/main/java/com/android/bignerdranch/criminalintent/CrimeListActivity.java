package com.android.bignerdranch.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by ConradC on 9/3/15.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
