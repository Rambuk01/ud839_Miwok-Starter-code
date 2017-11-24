package com.example.android.miwok;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);



        ArrayList<Word> colorWords = new ArrayList<>();
        colorWords.add(new Word("red", "weṭeṭṭi", R.drawable.color_red));
        colorWords.add(new Word("green", "chokokki", R. drawable.color_green));
        colorWords.add(new Word("brown", "ṭakaakki", R.drawable.color_brown));
        colorWords.add(new Word("gray", "ṭopoppi", R.drawable.color_gray));
        colorWords.add(new Word("black", "kululli", R.drawable.color_black));
        colorWords.add(new Word("white", "kelelli", R.drawable.color_white));
        colorWords.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow));
        colorWords.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow));

        WordAdapter colorWordAdapter = new WordAdapter(this, colorWords, R.color.category_colors);
        ListView colorListView = (ListView) findViewById(R.id.list);
        colorListView.setAdapter(colorWordAdapter);


    }
}
