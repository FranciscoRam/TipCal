package com.example.franks.tipcalc;


import android.app.Application;

public class TipCalcApp extends Application {
    private final static String ABOUT_URL = "http://www.google.com";

    public String getAboutUrl() {
        return ABOUT_URL;
    }
}