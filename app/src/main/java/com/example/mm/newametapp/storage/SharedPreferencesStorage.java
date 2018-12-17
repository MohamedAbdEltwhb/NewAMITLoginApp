package com.example.mm.newametapp.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import static com.example.mm.newametapp.helper.Constants.KEY_EMAIL;
import static com.example.mm.newametapp.helper.Constants.KEY_FNAME;
import static com.example.mm.newametapp.helper.Constants.KEY_IMAGE;
import static com.example.mm.newametapp.helper.Constants.KEY_LNAME;
import static com.example.mm.newametapp.helper.Constants.KEY_PASSWORD;
import static com.example.mm.newametapp.helper.Constants.KEY_PHONE;

public class SharedPreferencesStorage {

    public static boolean saveEmail(String email, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_EMAIL , email);
        editor.apply();
        return true;
    }

    public static String getEmail(Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String email = preferences.getString(KEY_EMAIL, null);
        return email;
    }

    public static boolean savePassword(String password, Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_PASSWORD, password);
        editor.apply();
        return true;
    }

    public static String getPassword(Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String password = preferences.getString(KEY_PASSWORD, null);
        return password;
    }

    public static boolean saveFirstName(String password, Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_FNAME, password);
        editor.apply();
        return true;
    }

    public static String getFirstName(Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String email = preferences.getString(KEY_FNAME, null);
        return email;
    }

    public static boolean saveLastName(String password, Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_LNAME, password);
        editor.apply();
        return true;
    }

    public static String getLastName(Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String email = preferences.getString(KEY_LNAME, null);
        return email;
    }

    public static boolean savePhone(String password, Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_PHONE, password);
        editor.apply();
        return true;
    }

    public static String getPhone(Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String email = preferences.getString(KEY_PHONE, null);
        return email;
    }

    public static boolean saveImage(String image, Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_IMAGE, image);
        editor.apply();
        return true;
    }

    public static String getImage(Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String email = preferences.getString(KEY_IMAGE, null);
        return email;
    }
}
