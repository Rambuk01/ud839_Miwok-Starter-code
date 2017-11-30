package com.example.android.miwok;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer player;
    ArrayList<Word> englishNumberWordsList;
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
        mAudioManager = (AudioManager) this.getSystemService(this.AUDIO_SERVICE);

        englishNumberWordsList = new ArrayList<>();
        englishNumberWordsList.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        englishNumberWordsList.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        englishNumberWordsList.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        englishNumberWordsList.add(new Word("four", "oyysia", R.drawable.number_four, R.raw.number_four));
        englishNumberWordsList.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        englishNumberWordsList.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        englishNumberWordsList.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        englishNumberWordsList.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        englishNumberWordsList.add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        englishNumberWordsList.add(new Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));

        afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
            @Override
            public void onAudioFocusChange(int i) {
                if(i == AudioManager.AUDIOFOCUS_GAIN) {
                    player.start();
                } else if(i == AudioManager.AUDIOFOCUS_LOSS) {
                    player.stop();
                    releaseMediaPlayer();
                } else if(i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                    player.pause();
                    player.seekTo(0);
                }
            }
        };

        WordAdapter wordAdapter = new WordAdapter(this, englishNumberWordsList, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                int focusGain = mAudioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
                if(focusGain == AudioManager.AUDIOFOCUS_GAIN) {
                    player = MediaPlayer.create(NumbersActivity.this, englishNumberWordsList.get(i).getmMediaResourceId());
                    player.start();
                    player.setOnCompletionListener(onCompletionListener);
                }
            }
        });
    }

    public void releaseMediaPlayer() {
        if(player != null) {
            player.release();
            player = null;
            mAudioManager.abandonAudioFocus(afChangeListener);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
