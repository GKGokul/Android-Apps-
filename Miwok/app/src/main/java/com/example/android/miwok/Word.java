package com.example.android.miwok;

/**
 * Created by gk on 5/3/17.
 */

public class Word {
    private String mEnglishTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId=NO_IMAGE_PROVIDED;
    private int mAudioResourceId;
    private static final int NO_IMAGE_PROVIDED=-1;


    public boolean hasImage(){
        return mImageResourceId!=NO_IMAGE_PROVIDED;
    }

    //First constructor only for phrases.xml with  no image.
    public Word(String englishtranslation,String miwoktranslation,int audioresourceid){
        mEnglishTranslation=englishtranslation;
        mMiwokTranslation=miwoktranslation;
        mAudioResourceId=audioresourceid;
    }
    //This is the second constructor
    public Word(String englishtranslation, String miwoktranslation,int imageresourceid,int audioresourceid){
        mEnglishTranslation=englishtranslation;
        mMiwokTranslation=miwoktranslation;
        mImageResourceId=imageresourceid;
        mAudioResourceId=audioresourceid;
    }

    public String getEnglishtranslation(){
        return mEnglishTranslation;
    }

    public String getMiwoktranslation(){ return mMiwokTranslation; }

    public int getImageResourceId(){ return mImageResourceId; }

    public int getAudioResourceId(){ return mAudioResourceId; }

}
