package com.example.tourguidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class NatureFragment extends Fragment {
    public NatureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);


        final ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(R.string.dzban_park, R.string.dzban_park_desc, R.drawable.dzban, "789654123", "http://www.poddzbansko.cz/tipy-na-vylety/prirodni-park-dzban/"));
        items.add(new Item(R.string.menhirs, R.string.menhirs_desc, R.drawable.menhir, null, null));
        items.add(new Item(R.string.stone_lines, R.string.stone_desc, R.drawable.stones, null, null));

        // Create an {@link ItemAdapter}, whose data source is a list of {@link Item}s. The
        // adapter knows how to create list items for each item in the list.
        ItemAdapter adapter = new ItemAdapter(getActivity(), items, R.color.nature_color);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // itemlist.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ItemAdapter} we created above, so that the
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
