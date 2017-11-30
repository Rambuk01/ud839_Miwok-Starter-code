package com.example.android.miwok;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
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
        mAudioManager = (AudioManager) this.getSystemService(this.AUDIO_SERVICE);

        final ArrayList<Word> colorWords = new ArrayList<>();
        colorWords.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        colorWords.add(new Word("green", "chokokki", R. drawable.color_green, R.raw.color_green));
        colorWords.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        colorWords.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        colorWords.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
        colorWords.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        colorWords.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colorWords.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        WordAdapter colorWordAdapter = new WordAdapter(this, colorWords, R.color.category_colors);
        ListView colorListView = (ListView) findViewById(R.id.list);
        afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
            @Override
            public void onAudioFocusChange(int i) {
                new AudioManager.OnAudioFocusChangeListener() {
                    @Override
                    public void onAudioFocusChange(int i) {
                        if(i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                            player.pause();
                        } else if(i == AudioManager.AUDIOFOCUS_LOSS) {
                            player.stop();
                            releaseMediaPlayer();
                        } else if(i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                            player.pause();
                        } else if(i == AudioManager.AUDIOFOCUS_GAIN) {
                            player.start();
                        }
                    }
                };
            }
        };

        colorListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                int focusGain = mAudioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if(focusGain == AudioManager.AUDIOFOCUS_GAIN) {
                    player = MediaPlayer.create(ColorsActivity.this, colorWords.get(i).getmMediaResourceId());
                    player.start();
                    player.setOnCompletionListener(onCompletionListener);
                }
            }
        });

        colorListView.setAdapter(colorWordAdapter);


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
