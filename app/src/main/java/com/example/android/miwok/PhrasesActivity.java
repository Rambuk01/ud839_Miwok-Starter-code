package com.example.android.miwok;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer player;
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    private AudioManager mAudioManager;
    private AudioManager.OnAudioFocusChangeListener afChangeListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        mAudioManager = (AudioManager) getApplicationContext().getSystemService(getApplicationContext().AUDIO_SERVICE);
        afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
            @Override
            public void onAudioFocusChange(int i) {
                if(i == AudioManager.AUDIOFOCUS_GAIN) {
                    player.start();
                } else if(i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK || i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                    player.pause();
                    player.seekTo(0);
                } else if(i == AudioManager.AUDIOFOCUS_LOSS) {
                    player.stop();
                    releaseMediaPlayer();
                }
            }
        };

        final ArrayList<Word> phraseWords = new ArrayList<>();
        phraseWords.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        phraseWords.add(new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        phraseWords.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        phraseWords.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        phraseWords.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        phraseWords.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        phraseWords.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        phraseWords.add(new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
        phraseWords.add(new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
        phraseWords.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));

        WordAdapter phrasesWordAdapter = new WordAdapter(this, phraseWords, R.color.category_phrases);
        ListView phraseListView = (ListView) findViewById(R.id.list);

        phraseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                int focusGain = mAudioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if(focusGain == AudioManager.AUDIOFOCUS_GAIN) {
                    player = MediaPlayer.create(getApplicationContext(), phraseWords.get(i).getmMediaResourceId());
                    player.start();
                    player.setOnCompletionListener(onCompletionListener);
                }
            }
        });

        phraseListView.setAdapter(phrasesWordAdapter);
    }
    public void releaseMediaPlayer() {
        if(player != null) {
            player.release();
            player = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
