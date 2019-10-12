package com.oluwatomilayo.learnyoruba;

import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

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

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "eeni", R.drawable.number_one, R.raw.one));
        words.add(new Word("two", "eeji", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "eeta", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "eerin", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "aron", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "eeni", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "eeje", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "eejo", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "eesan", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "eewa", R.drawable.number_ten, R.raw.number_ten));
        words.add(new Word("eleven", "ookanla", R.drawable.number_ten, R.raw.number_one));
        words.add(new Word("twelve", "eejila", R.drawable.number_ten, R.raw.oruko_rere_beautiful_nubia));
        words.add(new Word("thirteen", "etala", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("fourteen", "eerinla", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("fifteen", "arundinlogun", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("sixteen", "erindinlogun", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("seventeen", "etadinlogun", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("eighteen", "ejidinlogun", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("nineteen", "okandinlogun", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("twenty", "ogun", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("twenty", "okanlelogun", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("twenty two", "ejilelogun", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("twenty three", "etalelogun", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("twenty four", "erinlelogun", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("twenty five", "arundilogbon", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("twenty six", "erindinlogbon", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("twenty seven", "etadinlogbon", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("twenty eight", "ejidinlogbon", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("twenty nine", "okandinlogbon", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("thirty", "ogbon", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("thirty one", "okanlelogbon", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("thirty two", "ejilelogbon", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("thirty three", "etalelogbon", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("thirty four", "erinlelogbon", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("thirty five", "arundinlogoji", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("thirty six", "erindinlogoji", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("thirty seven", "etadinlogoji", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("thirty eight", "ejidinlogoji", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("thirty nine", "okandinlogoji", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("forty", "ogoji", R.drawable.number_one, R.raw.number_one));

        // Create an {@Link ArrayAdapter}, whose data is a list of Strings. The
        // adapters knows to create layouts for each item in the list.
        final WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

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
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());

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
