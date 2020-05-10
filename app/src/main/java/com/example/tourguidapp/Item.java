package com.example.tourguidapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Item to display in a fragment in a listview
 */
public class Item implements Parcelable {
    //id of the name of the item - name of the restaurant, attraction etc
    private int headerId;
    //id of the descritipn of the  of the restaurant, attraction etx
    private int descriptionId;
    //image resource id
    private int imageId;
    //phone for the rest etx id
    private int phoneId;
    //web page string id
    private int webId;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;
    /** Constant value that represents no phone string was provided for this word */
    private static final int NO_PHONE_PROVIDED = -1;
    /** Constant value that represents no web page string was provided for this word */
    private static final int NO_WEB_PROVIDED = -1;

    /**
     * constructor
     */
    public Item (int header, int desc, int image, int ph, int wb) {
        headerId = header;
        descriptionId = desc;
        imageId = image;
        phoneId = ph;
        webId = wb;
    }

    //parcel part
    public Item(Parcel in) {
        String[] data = new String[5];
        in.readStringArray(data);
        headerId = Integer.parseInt(data[0]);
        descriptionId = Integer.parseInt(data[1]);
        imageId = Integer.parseInt(data[2]);
        phoneId = Integer.parseInt(data[3]);
        webId = Integer.parseInt(data[4]);
    }

    /**
     * Returns whether or not there is an image for this item.
     */
    public boolean hasImage() {
        return imageId != NO_IMAGE_PROVIDED;
    }

    /**
     * Returns whether or not there is an phone for this item.
     */
    public boolean hasPhone() {
        return phoneId != NO_PHONE_PROVIDED;
    }

    /**
     * Returns whether or not there is an web for this item.
     */
    public boolean hasWeb() {
        return webId != NO_WEB_PROVIDED;
    }

    /**
     * Getters
     */

    public int getHeaderId() {
        return headerId;
    }
    public int getDescriptionId() {
        return descriptionId;
    }
    public int getImageId() {
        return imageId;
    }
    public int getPhone() {
        return phoneId;
    }
    public int getWeb() {
        return webId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{
                Integer.toString(headerId),
                Integer.toString(descriptionId),
                Integer.toString(imageId),
                Integer.toString(phoneId),
                Integer.toString(webId)
        });
    }

    public static final Parcelable.Creator<Item> CREATOR= new Parcelable.Creator<Item>() {

        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);  //using parcelable constructor
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}


