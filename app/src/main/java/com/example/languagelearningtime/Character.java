package com.example.languagelearningtime;

import android.graphics.Bitmap;
import android.graphics.RectF;

public class Character extends RectF {
    private Bitmap bitmap;
    private String name;
    private String mood;



    public Character( String name, String mood )
    {
        this.name = name;
        this.mood = mood;
    }
}
