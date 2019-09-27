package com.example.oluwatomilayo.learnyorubabasics;

import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

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
        words.add(new Word("Father", "Baba", R.drawable.family_father, R.raw.father));
        words.add(new Word("Mother", "Iya", R.drawable.family_mother, R.raw.mother));
        words.add(new Word("Boy", "Okunrin", R.drawable.family_son, R.raw.boy));
        words.add(new Word("Girl", "Obinrin", R.drawable.family_daughter, R.raw.girl));
        words.add(new Word("older brother", "egbon okunrin", R.drawable.family_older_brother, R.raw.elder_brother));
        words.add(new Word("younger brother", "aburo okunrin", R.drawable.family_younger_brother, R.raw.younger_brother));
        words.add(new Word("older sister", "egbon obinrin",R.drawable.family_older_sister, R.raw.elder_sister));
        words.add(new Word("younger sister", "aburo obinrin", R.drawable.family_younger_sister, R.raw.younger_sister));
        words.add(new Word("Grandmother", "Iya iya", R.drawable.family_grandmother, R.raw.grand_mother));
        words.add(new Word("Grandfather", "Baba baba", R.drawable.family_grandfather, R.raw.grand_father));

        // Create an {@Link ArrayAdapter}, whose data is a list of Strings. The
        // adapters knows to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework
        // This list item layout contains a single {@Link TextView}, which the adapter will set
        // display a single word.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);
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
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResourceId());

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
