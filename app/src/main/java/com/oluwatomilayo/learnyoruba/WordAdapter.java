package com.oluwatomilayo.learnyoruba;

import android.app.Activity;
import androidx.core.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by OLUWATOMILAYO on 21/08/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    /**Resource ID for the background color of this list of words*/
    private int mColorResourceId;

    /**
     * Create a new link {@Link WordAdapter} object.
     *
     * @param context is the current context (i.e Activity) that the adapter is being created in
     * @param words is the list of {@link Word}s to be displayed.
     */
    public WordAdapter(Activity context, ArrayList<Word> words,int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view2 is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TexyView in the list_xml layout with the ID version_name
        TextView yorubaTextView = (TextView)listItemView.findViewById(R.id.yoruba_text_view);
        // Get the version name from the current AndroidFlavor and set this text on the name TextView
        // the Yoruba TextView.
        yorubaTextView.setText(currentWord.getYorubaTranslation());

        // Find the TextView in the list_item_xml layout with the ID version_number
        TextView englishTextView = (TextView) listItemView.findViewById(R.id.english_text_view);
        // Get the version number from current AndroidFlavor object and Set this text on the number TextView
        // the English TextView.
        englishTextView.setText(currentWord.getEnglishTranslation());

        // Find the ImageView in the list_item.xml Layout with thwe ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if(currentWord.hasImage()){
        // Set the ImageView to the image resource  specified in the currrent Word
        imageView.setImageResource(currentWord.getmImageResourceId());

            //Make sure the view is visibile
            imageView.setVisibility(View.VISIBLE);
        }
        else{
           imageView.setVisibility(View.GONE);
            //Otherwise hide the ImageView (set visibility to GONE)
        }

        //Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color that the resource ID maps
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        //Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView) so that it can be shown in the ListView
        // the ListView.
        return listItemView;
    }
} 