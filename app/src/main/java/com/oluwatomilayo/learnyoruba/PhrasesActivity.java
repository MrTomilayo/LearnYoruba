package com.example.oluwatomilayo.learnyorubabasics;

import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

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
        words.add(new Word("How are you", "Bawo ni", R.raw.how_are_you));
        words.add(new Word("Am good", "Mo wa daadaa", R.raw.am_good));
        words.add(new Word("what's happening", "ki loun sele", R.raw.whats_happening));
        words.add(new Word("Good morning", "karo", R.raw.good_morning));
        words.add(new Word("Good afternoon", " ka san", R.raw.good_afternoon));
        words.add(new Word("Good evening", " ku irole", R.raw.good_evening));
        words.add(new Word("Good night", "o da ro", R.raw.good_night));
        words.add(new Word("Where are we?", "ibo la wa", R.raw.where_are_you));
        words.add(new Word("Don't be scared", "ma beru", R.raw.dont_be_scared));
        words.add(new Word("I love naija", "mo feran naija", R.raw.i_love_naija));
        words.add(new Word("Leave me alone", "fimi si le", R.raw.leave_me_alone));
        words.add(new Word("What can i do", "kini mo le se", R.raw.what_can_i_do));
        words.add(new Word("How much", "e lo ni", R.raw.how_much));
        words.add(new Word("Am learning yoruba", "mo ko yoruba", R.raw.am_learning_yoruba));
        words.add(new Word("i speak different languages", "mo so orisiris ede", R.raw.i_speak_different_language));
        words.add(new Word("Am going to school", "mo lo ile iwe", R.raw.am_going_to_school));
        words.add(new Word("Am going to church", "mo lo ile ijosin", R.raw.am_going_to_church));
        words.add(new Word("Am going to the hospital", "mo lo ile iwosan", R.raw.am_going_to_hospital));
        words.add(new Word("Am going to farm", "mo lo si oko", R.raw.am_going_to_church));
        words.add(new Word("Am going to work", "mo lo si ibi ise", R.raw.am_going_to_work));
        words.add(new Word("I love my country", "mo nife orilede mi", R.raw.i_love_my_country));
        words.add(new Word("Am a child of God", "omo olorun ni mi", R.raw.am_a_child_of_god));
        words.add(new Word("we love our culture", "a feran asa wa", R.raw.we_love_our_culture));
        words.add(new Word("Play gently", "sere jeje", R.raw.play_gently));
        words.add(new Word("Am a boy child", "omo okunrin ni mi", R.raw.am_a_boy_child));
        words.add(new Word("Am a girl child", "omo okunrin ni mi", R.raw.am_a_girl_child));
        words.add(new Word("Tell me something new", "so ikan titun fun mi", R.raw.tell_me_something_new));
        words.add(new Word("Who are they?", "tani won?", R.raw.who_are_they));
        words.add(new Word("sit down here", "joko si ibi", R.raw.sit_here));
        words.add(new Word("Stand up", "dide", R.raw.stand));
        words.add(new Word("Thanks for yesterday", "e se ana", R.raw.thanks_for_yesterday));
        words.add(new Word("Where are you", "Ibo lo wa", R.raw.where_are_you));
        words.add(new Word("Let's go there", "Je ka lo si bee", R.raw.lets_go_there));
        words.add(new Word("Let's eat", "je ka jeun", R.raw.lets_eat));
        words.add(new Word("What's your name", "kini oruko e", R.raw.what_is_your_name));
        words.add(new Word("Am hungry", "ebi un pa mi", R.raw.am_hungry));
        words.add(new Word("what do you want to do", "ki lo fe se", R.raw.what_do_you_want_to_do));
        words.add(new Word("I don't understand", "ko ye mi", R.raw.i_dont_understand));
        words.add(new Word("Am about to start", "mo ti fe bere", R.raw.am_about_to_start));
        words.add(new Word("I want to eat", "mo fe jeun", R.raw.i_want_to_eat));
        words.add(new Word("I want to read", "mo fe kawe", R.raw.i_want_to_read));
        words.add(new Word("What should we do", "ki ni ka se", R.raw.what_should_we_do));
        words.add(new Word("I love my country", "Mo feran orilede mi", R.raw.i_love_my_country));
        words.add(new Word("God is good", "Olorun dara", R.raw.god_is_good));
        words.add(new Word("My father is a civil servant", "Osise ijoba ni baba mi", R.raw.my_father_is_a_civil_servant));
        words.add(new Word("Only God knows tomorrow", "Olorun nikan lo mo ola", R.raw.only_god_know_tomorrow));
        words.add(new Word("How much", "e lo ni", R.raw.how_much));
        words.add(new Word("What do you want to buy", "ki lke fe ra", R.raw.what_do_you_want_to_buy));
        words.add(new Word("Thank you very much", "e se gan ni o", R.raw.thank_you_very_much));
        words.add(new Word("Stop thinking", "ma ro inu mo", R.raw.stop_thinking));
        words.add(new Word("My life is good", "aye mi dara", R.raw.my_life_is_good));
        words.add(new Word("You make me laugh", "O pa mi leri", R.raw.you_make_me_laugh));
        words.add(new Word("Please calm down", "joo fi ara bale", R.raw.please_calm_down));


        // Create an {@Link ArrayAdapter}, whose data is a list of Strings. The
        // adapters knows to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework
        // This list item layout contains a single {@Link TextView}, which the adapter will set
        // display a single word.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

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
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());

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
