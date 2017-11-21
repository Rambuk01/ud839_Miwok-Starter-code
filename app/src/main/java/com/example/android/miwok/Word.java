package com.example.android.miwok;
/*
The word class is ment to contain an english and miwok translation of a single word.
 */
public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;

    public Word(String defaultTranslation, String miwokTranslation) {
        this.mMiwokTranslation = miwokTranslation;
        this.mDefaultTranslation = defaultTranslation;
    }

    public String getMiwokTranslation() {
        return this.mMiwokTranslation;
    }
    public String getDefaultTranslation() {
        return this.mDefaultTranslation;
    }
}
