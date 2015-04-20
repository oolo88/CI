package com.android.bignerdranch.criminalintent;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by ConradC on 7/3/15.
 */
public class CrimeLab {
    public static final String TAG = "CrimeLab";
    public static final String FILENAME = "crime.json";

    private ArrayList<Crime> mCrimes;
    private CriminalIntentJSONSerializer mSerializer;

    private static CrimeLab sCrimelab;
    private Context mAppContext;

    private CrimeLab(Context appContext) {
        mAppContext = appContext;
        mCrimes = new ArrayList<Crime>();
        mSerializer = new CriminalIntentJSONSerializer(appContext, FILENAME);

        try {
            mCrimes = mSerializer.loadCrimes();
        } catch (Exception e) {
            mCrimes = new ArrayList<Crime>();
            Log.e(TAG, "Error loading crimes: ", e);
        }
    }


    public static CrimeLab get(Context c) {
        if (sCrimelab == null) {
            sCrimelab = new CrimeLab(c.getApplicationContext());
        }
        return sCrimelab;
    }

    public ArrayList<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime c: mCrimes) {
            if (c.getId().equals(id))
                return c;
        }
        return null;
    }

    public void addCrime(Crime c) {
        mCrimes.add(c);
    }


    public boolean saveCrimes() {
        try {
            mSerializer.saveCrimes(mCrimes);
            Log.d(TAG, "crimes saved to file");
            return true;
        } catch (Exception e) {
            Log.e(TAG, "Error saving crimes: ", e);
            return false;
        }
    }

    public void deleteCrime(Crime c) {
        mCrimes.remove(c);
    }
}

