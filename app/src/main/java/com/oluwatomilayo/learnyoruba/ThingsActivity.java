package com.oluwatomilayo.learnyoruba;

import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ThingsActivity extends AppCompatActivity {
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
        words.add(new Word("Cloth", "aso", R.raw.cloth));
        words.add(new Word("House", "ile", R.raw.house));
        words.add(new Word("Door", "lekun", R.raw.door));
        words.add(new Word("Money", "owo", R.raw.money));
        words.add(new Word("Wealth", "oola", R.raw.wealth));
        words.add(new Word("Water", "omi",R.raw.water));
        words.add(new Word("Day", "ojo", R.raw.day));
        words.add(new Word("Sand", "yepe", R.raw.sand));
        words.add(new Word("Book", "iwe", R.raw.book));
        words.add(new Word("Iron", "irin", R.raw.iron));
        words.add(new Word("Week", "ose", R.raw.week));
        words.add(new Word("Day", "ojo", R.raw.day));
        words.add(new Word("Word", "oro", R.raw.word));
        words.add(new Word("Weather", "oju ojo", R.raw.wealth));
        words.add(new Word("Air", "afefe", R.raw.air));
        words.add(new Word("Carton", "pali", R.raw.carton));
        words.add(new Word("Book", "iwe", R.raw.book));
        words.add(new Word("Fire", "ina", R.raw.fire));
        words.add(new Word("Sand", "yepe", R.raw.sand));
        words.add(new Word("Water","omi", R.raw.water));
        words.add(new Word("Rain", "ojo", R.raw.rain));
        words.add(new Word("Hospital", "ile iwosan", R.raw.hospital));
        words.add(new Word("Church", "ile ijosin", R.raw.church));
        words.add(new Word("School", "ile iwe", R.raw.school));
        words.add(new Word("Prison", "ogba ewon", R.raw.prison));
        words.add(new Word("family","ebi", R.raw.family));
        words.add(new Word("Spirit", "eemi", R.raw.spirit));

        // Create an {@Link ArrayAdapter}, whose data is a list of Strings. The
        // adapters knows to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework
        // This list item layout contains a single {@Link TextView}, which the adapter will set
        // display a single word.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_things);

        // Find the {@Link ListView} object in the view hierarchy of the {@Link Activty}.
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
                mMediaPlayer = MediaPlayer.create(ThingsActivity.this, word.getAudioResourceId());

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


