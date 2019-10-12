package com.oluwatomilayo.learnyoruba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main_java
        setContentView(R.layout.activity_main);

        //Find the view that shows the numbers category
        TextView numbers = (TextView)findViewById(R.id.numbers);

        //Set a clickListener on that View
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create a new intent to open the {@Link NumbersActivity}
                Intent numbersIntent = new Intent(MainActivity.this, com.oluwatomilayo.learnyoruba.NumbersActivity.class);

                //Start the new activity
                startActivity(numbersIntent);
            }
        });

        //Find the view that shows the family category
        TextView family = (TextView)findViewById(R.id.family);

        //Set a clickListener on that View
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create a new intent to open the {@Link FamilyActivity}
                Intent familyIntent = new Intent(MainActivity.this, com.oluwatomilayo.learnyoruba.FamilyActivity.class);

                //Start the new activity
                startActivity(familyIntent);
            }
        });

        //Find the view that shows the colors category
        TextView colors = (TextView)findViewById(R.id.colors);

        //Set a clickListener on that View
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create a new intent to open the {@Link ColorsActivity}
                Intent colorsIntent = new Intent(MainActivity.this, com.oluwatomilayo.learnyoruba.ColorsActivity.class);

                //Start the new activity
                startActivity(colorsIntent);
            }
        });

        //Find the view that shows the phrases category
        TextView phrases = (TextView)findViewById(R.id.phrases);

        //Set a clickListener on that View
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create a new intent to open the {@Link ColorsActivity}
                Intent phrasesIntent = new Intent(MainActivity.this, com.oluwatomilayo.learnyoruba.PhrasesActivity.class);

                //Start the new activity
                startActivity(phrasesIntent);
            }
        });

        //Find the view that shows the things category
        TextView things = (TextView)findViewById(R.id.things);

        //Set a clickListener on that View
        things.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create a new intent to open the {@Link ColorsActivity}
                Intent thingsIntent = new Intent(MainActivity.this, com.oluwatomilayo.learnyoruba.ThingsActivity.class);

                //Start the new activity
                startActivity(thingsIntent);
            }
        });

        //Find the view that shows the months category
        TextView months = (TextView)findViewById(R.id.months);

        //Set a clickListener on that View
        months.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create a new intent to open the {@Link ColorsActivity}
                Intent monthsIntent = new Intent(MainActivity.this, com.oluwatomilayo.learnyoruba.MonthsActivity.class);

                //Start the new activity
                startActivity(monthsIntent);
            }
        });

    }
}
