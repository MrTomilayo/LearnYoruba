package com.example.oluwatomilayo.learnyorubabasics;

import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MonthsActivity extends AppCompatActivity {

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

        //words.add("one");
        words.add(new Word("January", "Seere", R.raw.january));
        words.add(new Word("Febuary", "erele", R.raw.febuary));
        words.add(new Word("March", "erena", R.raw.march));
        words.add(new Word("April", "igbe", R.raw.april));
        words.add(new Word("May", "owiwi", R.raw.may));
        words.add(new Word("June", "okudu", R.raw.jun));
        words.add(new Word("July", "agemo", R.raw.jun));
        words.add(new Word("August", "ogun", R.raw.august));
        words.add(new Word("September", "owewe", R.raw.jun));
        words.add(new Word("Octocber", "owara", R.raw.october));
        words.add(new Word("November", "belu", R.raw.november));
        words.add(new Word("December", "ope", R.raw.december));

        // Create an {@Link ArrayAdapter}, whose data is a list of Strings. The
        // adapters knows to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework
        // This list item layout contains a single {@Link TextView}, which the adapter will set
        // display a single word.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_months);

        // Find the {@Link ListView} object in the view hierarchy of the {@Link Activty}.
        // There should be a {@Link ListView} with the view ID callede List, which is declared in
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
                mMediaPlayer = MediaPlayer.create(MonthsActivity.this, word.getAudioResourceId());

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
