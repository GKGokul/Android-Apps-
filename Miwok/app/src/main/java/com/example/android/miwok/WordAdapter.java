package com.example.android.miwok;


import android.app.Activity;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gk on 5/3/17.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    //construct
    public WordAdapter(Activity context, ArrayList<Word> words, int ColorResourceId) {

        super(context, 0, words);
        mColorResourceId=ColorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word curengword = getItem(position);
        TextView englishtextView = (TextView) listItemView.findViewById(R.id.english_text_view);
        englishtextView.setText(curengword.getEnglishtranslation());

        Word curmiwokword = getItem(position);
        TextView miwoktextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwoktextView.setText(curmiwokword.getMiwoktranslation());

        Word curimage = getItem(position);
        ImageView imageview = (ImageView) listItemView.findViewById(R.id.image);

        if(curimage.hasImage()){
            imageview.setImageResource(curimage.getImageResourceId());
            imageview.setVisibility(View.VISIBLE);
        }
        else{
            imageview.setVisibility(View.GONE);
        }


        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
