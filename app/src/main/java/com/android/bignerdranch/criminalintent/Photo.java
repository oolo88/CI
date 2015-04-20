package com.android.bignerdranch.criminalintent;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ConradC on 20/4/15.
 */
public class Photo {
    public static final String JSON_FILENAME = "filename";

    private String mFilename;

    public Photo(String filename) {
        mFilename = filename;
    }

    public Photo(JSONObject json) throws JSONException {
        mFilename = json.getString(JSON_FILENAME);
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(JSON_FILENAME, mFilename);
        return json;
    }

    public String getFilename() {
        return mFilename;
    }
}
