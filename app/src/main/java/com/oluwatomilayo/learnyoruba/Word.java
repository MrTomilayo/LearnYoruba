package com.example.oluwatomilayo.learnyorubabasics;

/**
 * {@Link Word} represents a vocabulary word that the user wants to learn.
 * It contain the English translation and the Yoruba translation for that words.
 */
public class Word {

    /** English translation for the word */
    private String mEnglishTranslation;

    /**  English translation for the word */
    private String mYorubaTranslation;

    /** Image resource ID for the word*/
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /* Constant value that represent no image was provided for this word. */
    private static final int NO_IMAGE_PROVIDED = -1;

    /** Audio resource ID for word*/
    private int mAudioResourceId;

    /**
     * Create a new Word object.
     *
     * @param englishTranslation is the word in a English language
     * @param yorubaTranslation is the  word in Yoruba language
     * @param
     */

    public  Word(String englishTranslation, String yorubaTranslation, int audioResourceId) {
        mEnglishTranslation = englishTranslation;
        mYorubaTranslation = yorubaTranslation;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Create a new Word object.
     *
     * @param englishTranslation is the word in a English language
     * @param yorubaTranslation is the  word in Yoruba language
     *
     * @param imageResourceId is the drawable resource ID for the image asset
     */

    public  Word(String englishTranslation, String yorubaTranslation, int imageResourceId,int audioResourceId ) {
        mEnglishTranslation = englishTranslation;
        mYorubaTranslation = yorubaTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Get the english translation of the word.
     */
    public String getEnglishTranslation() {
        return mEnglishTranslation;
    }

    /**
     * Get the yoruba translation of the word.
     */
    public String getYorubaTranslation() {
        return mYorubaTranslation;
    }

    /**
     * Return the image resource ID of the word.
     */
    public int getmImageResourceId(){return mImageResourceId; }

    /**
     * Returns Whether or not there is an image for this word.
     *
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Return the audio resource ID of the word.
     * @return
     */
    public int getAudioResourceId() { return mAudioResourceId;}
}