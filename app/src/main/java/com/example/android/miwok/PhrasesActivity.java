package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> phraseWords = new ArrayList<>();
        phraseWords.add(new Word("Where are you going?", "minto wuksus"));
        phraseWords.add(new Word("What is your name?", "tinnә oyaase'nә"));
        phraseWords.add(new Word("My name is...", "oyaaset..."));
        phraseWords.add(new Word("How are you feeling?", "michәksәs?"));
        phraseWords.add(new Word("I’m feeling good.", "kuchi achit"));
        phraseWords.add(new Word("Are you coming?", "әәnәs'aa?"));
        phraseWords.add(new Word("Yes, I’m coming.", "hәә’ әәnәm"));
        phraseWords.add(new Word("I’m coming.", "әәnәm"));
        phraseWords.add(new Word("Let’s go.", "yoowutis"));
        phraseWords.add(new Word("Come here.", "әnni'nem"));

        WordAdapter phrasesWordAdapter = new WordAdapter(this, phraseWords);
        ListView phraseListView = (ListView) findViewById(R.id.list);
        phraseListView.setAdapter(phrasesWordAdapter);
    }
}
