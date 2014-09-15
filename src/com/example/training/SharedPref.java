package com.example.training;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    public void save(Activity activity, String account, String password) {
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("accont", account);
        editor.putString("password", password);
        editor.commit();
    }
    
    public String[] load(Activity activity) {
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        String[] data = {sharedPref.getString("accont", ""), sharedPref.getString("password", "")};
        return data;
    }
}
