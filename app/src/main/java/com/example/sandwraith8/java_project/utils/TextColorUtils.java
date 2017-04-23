package com.example.sandwraith8.java_project.utils;

import android.text.Html;
import android.text.Spanned;
import android.util.Log;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sandwraith8 on 21/04/2017.
 */

public class TextColorUtils {
    public static Spanned changeTextColor(String key, String text) {
        StringBuilder stringBuilder = new StringBuilder();
        Matcher matcher = Pattern.compile(Pattern.quote(key), Pattern.CASE_INSENSITIVE).matcher(text);
        String s = key;
        if (matcher.find()) {
            s = matcher.group();
        }
//        Log.i("color", s);
        String[] array = text.split(Pattern.quote(s));
//        Log.i("length", "" + array.length);

        if (array.length > 1) {
            for (int i = 0; i < array.length - 1; i++) {
                stringBuilder.append(array[i] + "<font color='yellow'>" + s + "</font>");
            }
            stringBuilder.append(array[array.length - 1]);
        } else {
            if (array.length == 1)
                if (text.contains(s))
                    stringBuilder.append(array[0] + "<font color='yellow'>" + s + "</font>");
                else
                    stringBuilder.append(array[0]);
        }
        return Html.fromHtml(stringBuilder.toString());
    }

    public static Spanned changeTextColor(ArrayList<String> keys, String text) {
//        StringBuilder stringBuilder = new StringBuilder(text);
        for (String key : keys) {
//            Log.e("abc", key);
//            Log.e("sdsdsd", "<font color='yellow'>" + key + "</font>");
            text = text.replace(key, "<font color='yellow'>" + key + "</font>");
//            Log.e("a", text);
//            Matcher matcher = Pattern.compile(Pattern.quote(key), Pattern.CASE_INSENSITIVE).matcher(text);
//            String s = key;
//            if (matcher.find()) {
//                s = matcher.group();
//            }
//        Log.i("color", s);
//            String[] array = text.split(Pattern.quote(s));
//        Log.i("length", "" + array.length);

//            if (array.length > 1) {
//                for (int i = 0; i < array.length - 1; i++) {
//                    stringBuilder.append(array[i] + "<font color='yellow'>" + s + "</font>");
//                }
//                stringBuilder.append(array[array.length - 1]);
//            } else {
//                if (array.length == 1)
//                    if (text.contains(s))
//                        stringBuilder.append(array[0] + "<font color='yellow'>" + s + "</font>");
//                    else
//                        stringBuilder.append(array[0]);
//            }
        }
        return Html.fromHtml(text);
    }
}

