package com.example.android.miwok;

import android.view.View;
import android.widget.ImageView;

/*
The word class is ment to contain an english and miwok translation of a single word.
 */
public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mImageResourceId = View.GONE;

    public Word(String defaultTranslation, String miwokTranslation) {
        this.mMiwokTranslation = miwokTranslation;
        this.mDefaultTranslation = defaultTranslation;
    }

    public Word(String defaultTranslation, String miwokTranslation, int image) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
        this.mImageResourceId = image;
    }

    public String getMiwokTranslation() {
        return this.mMiwokTranslation;
    }
    public String getDefaultTranslation() {
        return this.mDefaultTranslation;
    }
    public int getmImageResourceId() {return this.mImageResourceId;}
    public boolean hasImage() {
        if(mImageResourceId == View.GONE) {
            return false;
        } else {
            return true;
        }
    }
}
