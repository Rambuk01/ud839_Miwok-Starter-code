package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
        englishNumberWordsList.add(new Word("one", "lutti"));
        englishNumberWordsList.add(new Word("two", "otiiko"));
        englishNumberWordsList.add(new Word("three", "tolookosu"));
        englishNumberWordsList.add(new Word("four", "oyysia"));
        englishNumberWordsList.add(new Word("five", "massokka"));
        englishNumberWordsList.add(new Word("six", "temmokka"));
        englishNumberWordsList.add(new Word("seven", "kenekaku"));
        englishNumberWordsList.add(new Word("eight", "kawinta"));
        englishNumberWordsList.add(new Word("nine", "wo'e"));
        englishNumberWordsList.add(new Word("ten", "na'aacha"));
    }

    private void setListViewAdapter() {
        WordAdapter wordAdapter = new WordAdapter(this, englishNumberWordsList);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
    }
}
