package com.example.tourguidapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);


        final ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(R.string.zichovec_rest, R.string.zichovec_rest_desc, R.drawable.zichovec_rest, "65478913", "http://www.novanaves.cz/denni-menu"));
        items.add(new Item(R.string.pila_rest, R.string.pila_rest_dest, R.drawable.pila_rest, "654789321", "http://www.penzionnapile.cz/"));

        // Create an {@link Itemdapter}, whose data source is a list of {@link Item}s. The
        // adapter knows how to create list items for each item in the list.
        ItemAdapter adapter = new ItemAdapter(getActivity(), items, R.color.rest_color);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // itemlist.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WItemAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Item} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Item} object at the given position the user clicked on
                Item item = items.get(position);
                Intent detailIntent = new Intent(getActivity(), Detail.class);
                detailIntent.putExtra("item", item);
                startActivity(detailIntent);
            }
        });

        return rootView;
    }
}
