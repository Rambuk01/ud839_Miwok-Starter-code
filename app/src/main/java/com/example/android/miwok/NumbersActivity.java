package com.example.android.miwok;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    ArrayList<Word> englishNumberWordsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        setLayout();
    }
    private void setLayout() {
        addNumbers();
        setListViewAdapter();
    }
    private void addNumbers() {
        englishNumberWordsList = new ArrayList<>();
        englishNumberWordsList.add(new Word("one", "lutti", R.drawable.number_one));
        englishNumberWordsList.add(new Word("two", "otiiko", R.drawable.number_two));
        englishNumberWordsList.add(new Word("three", "tolookosu", R.drawable.number_three));
        englishNumberWordsList.add(new Word("four", "oyysia", R.drawable.number_four));
        englishNumberWordsList.add(new Word("five", "massokka", R.drawable.number_five));
        englishNumberWordsList.add(new Word("six", "temmokka", R.drawable.number_six));
        englishNumberWordsList.add(new Word("seven", "kenekaku", R.drawable.number_seven));
        englishNumberWordsList.add(new Word("eight", "kawinta", R.drawable.number_eight));
        englishNumberWordsList.add(new Word("nine", "wo'e", R.drawable.number_nine));
        englishNumberWordsList.add(new Word("ten", "na'aacha", R.drawable.number_ten));
    }

    private void setListViewAdapter() {
        WordAdapter wordAdapter = new WordAdapter(this, englishNumberWordsList, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        //int color = getResources().getColor(R.color.category_numbers);
        //listView.setBackgroundColor(color);
        listView.setAdapter(wordAdapter);
    }
}
