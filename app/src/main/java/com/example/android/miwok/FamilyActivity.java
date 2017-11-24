package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        //setTitle(getString(R.string.category_family));

        ArrayList<Word> familyWords = new ArrayList<>();
        familyWords.add(new Word("father", "әpә", R.drawable.family_father));
        familyWords.add(new Word("mother", "әṭa", R.drawable.family_mother));
        familyWords.add(new Word("son", "angsi", R.drawable.family_son));
        familyWords.add(new Word("daughter", "tune", R.drawable.family_daughter));
        familyWords.add(new Word("older brother", "taachi", R.drawable.family_older_brother));
        familyWords.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother));
        familyWords.add(new Word("older sister", "teṭe", R.drawable.family_older_sister));
        familyWords.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister));
        familyWords.add(new Word("grandmother", "ama", R.drawable.family_grandmother));
        familyWords.add(new Word("grandfather", "paapa", R.drawable.family_grandfather));

        WordAdapter familyWordAdapter = new WordAdapter(this, familyWords, R.color.category_family);
        Log.e("Something something", "Color set on Family activity " + R.color.category_family);
        ListView familyListView = (ListView) findViewById(R.id.list);
        familyListView.setAdapter(familyWordAdapter);
    }
}
