package com.oluwatomilayo.learnyoruba;

import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    //** Handles playback of all the sound files*/
    private MediaPlayer mMediaPlayer;

    /**
     *This Listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create an array of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("black", "dudu", R.drawable.color_black, R.raw.younger_brother));
        words.add(new Word("brown", "awo idi", R.drawable.color_brown, R.raw.younger_brother));
        words.add(new Word("gray", "awo eeru", R.drawable.color_gray, R.raw.younger_brother));
        words.add(new Word("green", "awo ewe", R.drawable.color_green, R.raw.younger_brother));
        words.add(new Word("red", "pupa", R.drawable.color_red, R.raw.younger_brother));
        words.add(new Word("white", "funfun", R.drawable.color_white, R.raw.younger_brother));
        words.add(new Word("yellow", "pupa rusurusu",R.drawable.color_mustard_yellow, R.raw.younger_brother));

        final WordAdapter adapter = new WordAdapter(this, words, R.color.category_color);

        // Find the {@Link ListView} object in the view hierarchy of the {@Link Activity}.
        // There should be a {@Link ListView} with the view ID called List, which is declared in
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.List);

        // Make the {@link ListView} use the {@Link ArrayAdapter} created above, so that the
        // {@Link listView} will display list items for each word in the list of words.
        // 1 argument, which is the {@LInk ArrayAdapter} with the variable.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Word word = words.get(position);

                // Release the media player if it currently exist because we are about to
                // play a different sound file.
                releaseMediaPlayer();

                // Create and setup the {@Link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();

                // Setup a listener on the media player, so that we can stop and release
                // media player once the sound has finished playing
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });

    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media Player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null)
            // Regardless of the current state of the media player, release its resource
            // because we no longer need it.
            mMediaPlayer.release();

        // Set the media player back to null. for our code, we've decided that
        // setting the media player to null is an easy way to tell that the media player
        // is not configure to play an audio file at the moment.
        mMediaPlayer = null;
    }
}
