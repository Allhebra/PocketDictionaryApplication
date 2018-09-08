package com.bereg.pocketdictionaryapplication.data;

import android.content.SharedPreferences;

/**
 * Created by 1 on 22.07.2018.
 */

public class SharedPreferencesManager {

    private static final String TAG = SharedPreferencesManager.class.getSimpleName();
    private static final String TOKEN = "token";
    private SharedPreferences mPrefs;

    public SharedPreferencesManager(SharedPreferences sharedPreferences) {
        mPrefs = sharedPreferences;
    }

    public String readToken() {

        return mPrefs.getString(TOKEN, "no_token");
    }

    public void saveToken(String token) {
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString(TOKEN, token);
        editor.apply();
    }
}
