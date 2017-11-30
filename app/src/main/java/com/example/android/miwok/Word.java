package com.example.android.miwok;

import android.view.View;

/*
The word class is ment to contain an english and miwok translation of a single word.
 */
public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mImageResourceId = View.GONE;
    private int mMediaResourceId = 0;

    public Word(String defaultTranslation, String miwokTranslation) {
        this.mMiwokTranslation = miwokTranslation;
        this.mDefaultTranslation = defaultTranslation;
    }

    public Word(String defaultTranslation, String miwokTranslation, int mMediaResourceId) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
        this.mMediaResourceId = mMediaResourceId;
    }

    public Word(String defaultTranslation, String miwokTranslation, int image, int mMediaResourceId) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
        this.mImageResourceId = image;
        this.mMediaResourceId = mMediaResourceId;
    }

    public String getMiwokTranslation() {
        return this.mMiwokTranslation;
    }
    public String getDefaultTranslation() {
        return this.mDefaultTranslation;
    }
    public int getmImageResourceId() {return this.mImageResourceId;}
    public int getmMediaResourceId() {return mMediaResourceId;}
    public boolean hasImage() {
        if(mImageResourceId == View.GONE) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Word{" +
                "mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mMediaResourceId=" + mMediaResourceId +
                '}';
    }
}
