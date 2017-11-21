package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> colorWords = new ArrayList<>();
        colorWords.add(new Word("red", "weṭeṭṭi"));
        colorWords.add(new Word("green", "chokokki"));
        colorWords.add(new Word("brown", "ṭakaakki"));
        colorWords.add(new Word("gray", "ṭopoppi"));
        colorWords.add(new Word("black", "kululli"));
        colorWords.add(new Word("white", "kelelli"));
        colorWords.add(new Word("dusty yellow", "ṭopiisә"));
        colorWords.add(new Word("mustard yellow", "chiwiiṭә"));

        WordAdapter colorWordAdapter = new WordAdapter(this, colorWords);
        ListView colorListView = (ListView) findViewById(R.id.list);
        colorListView.setAdapter(colorWordAdapter);
    }
}
