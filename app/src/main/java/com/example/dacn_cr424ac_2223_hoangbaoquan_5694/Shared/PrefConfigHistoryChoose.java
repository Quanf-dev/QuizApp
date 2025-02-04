package com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Shared;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.NumQuestion;
import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Quiz.Question;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PrefConfigHistoryChoose {
    private static final String LIST_KEY = "list_key102";

    public static void writeListInPref(Context context, ArrayList<Question> list) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(list);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(LIST_KEY, jsonString);
        editor.apply();
    }

    public static ArrayList<Question> readListFromPref(Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString(LIST_KEY, "");

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Question>>() {}.getType();
        ArrayList<Question> list = gson.fromJson(jsonString, type);
        return list;
    }
}
