package com.example.tourguidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //get current item
        Item item = getIntent().getParcelableExtra("item");


        //find the TextView in the list_item.xml layout with the ID heading_text_view.
        TextView headingTextView = (TextView) findViewById(R.id.name_detail);
        //set the heading of the item
        headingTextView.setText(item.getHeaderId());

        //find the TextView in the list_item.xml layout with the ID description_text_view.
        TextView descriptionTextView = (TextView) findViewById(R.id.desc_detail);
        //set the description of the item
        descriptionTextView.setText(item.getDescriptionId());

        //find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) findViewById(R.id.image_detail);
        //check if an image is provided for this item or not
        if (item.hasImage()) {
            //if an image is available, display the provided image based on the resource ID
            imageView.setImageResource(item.getImageId());
            //make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            //otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        //find the ImageView in the list_item.xml layout with the ID image.
        TextView phoneTextView = (TextView) findViewById(R.id.phone_detail);
        //check if an image is provided for this item or not
        if (item.hasPhone()) {
            //if an image is available, display the provided image based on the resource ID
            phoneTextView.setText(item.getPhone());
            //make sure the view is visible
            phoneTextView.setVisibility(View.VISIBLE);
        } else {
            //otherwise hide the ImageView (set visibility to GONE)
            phoneTextView.setVisibility(View.GONE);
        }

        //find the ImageView in the list_item.xml layout with the ID image.
        TextView webTextView = (TextView) findViewById(R.id.web_detail);
        //check if an image is provided for this item or not
        if (item.hasWeb()) {
            //if an image is available, display the provided image based on the resource ID
            webTextView.setText(item.getWeb());
            //make sure the view is visible
            webTextView.setVisibility(View.VISIBLE);
        } else {
            //otherwise hide the ImageView (set visibility to GONE)
            webTextView.setVisibility(View.GONE);
        }

    }
}
