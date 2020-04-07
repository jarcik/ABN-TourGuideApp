package com.example.tourguidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

/**
 * Provides the layout for each list item based on the data source
 */
public class ItemAdapter extends ArrayAdapter<Item> {

    /**
     * resource id for the background of the item in the list
     */
    private int colorId;

    /**
     * Constructor
     * @param context current context from the activity
     * @param items list of items being displayed
     * @param colorResourceId resource id for the background of one item in a list
     */
    public ItemAdapter(Context context, ArrayList<Item> items, int colorResourceId) {
        super(context, 0, items);
        colorId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //get the item object located at this position in the list
        Item currentItem = getItem(position);

        //find the TextView in the list_item.xml layout with the ID heading_text_view.
        TextView headingTextView = (TextView) listItemView.findViewById(R.id.heading_text_view);
        //set the heading of the item
        headingTextView.setText(currentItem.getHeaderId());

        //find the TextView in the list_item.xml layout with the ID description_text_view.
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
        //set the description of the item
        descriptionTextView.setText(currentItem.getDescriptionId());

        //find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        //check if an image is provided for this word or not
        if (currentItem.hasImage()) {
            //if an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentItem.getImageId());
            //make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            //otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        //set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), colorId);
        //set the background color of the text container View
        textContainer.setBackgroundColor(color);

        //return the whole list item layout so that it can be shown in the ListView
        return listItemView;
    }
}
