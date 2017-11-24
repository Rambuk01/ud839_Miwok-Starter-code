package com.example.android.miwok;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by feste on 20-11-2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;
    private View listItemView;

    public WordAdapter(Context context, ArrayList<Word> words, int colorResource) {
        super(context, 0, words);
        mColorResourceId = colorResource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word word = getItem(position);
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(word.getDefaultTranslation());

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(word.getMiwokTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.imageIcon);
        if(word.hasImage()) {
            imageView.setImageResource(word.getmImageResourceId());
        } else {
            imageView.setVisibility(View.GONE);
        }
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        View textContainer = listItemView.findViewById(R.id.text_background_color);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
