package android.mobilesenegal.sn.stateslistproject;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    ListView listView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        listView = (ListView) rootView.findViewById(R.id.maliste);

        String[] villes = { "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado",
                "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois",
                "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
                "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana",
                "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York",
                "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
                "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah",
                "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                R.layout.listviewitem, R.id.states, villes);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Log.i("hello", "Alabama");
                    Toast.makeText(getContext(), "Alabama", Toast.LENGTH_SHORT).show();
                } else if (position == 1) {
                    Log.i("hello", "Alaska");
                    Toast.makeText(getContext(), "Alaska", Toast.LENGTH_SHORT).show();
                } else if (position == 2) {
                    Log.i("hello", "Arizona");
                    Toast.makeText(getContext(), "Arizona", Toast.LENGTH_SHORT).show();
                } else if (position == 3) {
                    Log.i("hello", "Arkansas");
                    Toast.makeText(getContext(), "Arkansas", Toast.LENGTH_SHORT).show();
                } else if (position == 4) {
                    Log.i("hello", "California");
                    Toast.makeText(getContext(), "California", Toast.LENGTH_SHORT).show();
                } else if (position == 5) {
                    Log.i("hello", "Colorado");
                    Toast.makeText(getContext(), "Colorado", Toast.LENGTH_SHORT).show();
                } else if (position == 6) {
                    Log.i("hello", "Connecticut");
                    Toast.makeText(getContext(), "Connecticut", Toast.LENGTH_SHORT).show();
                } else if (position == 7) {
                    Log.i("hello", "Delaware");
                    Toast.makeText(getContext(), "Delaware", Toast.LENGTH_SHORT).show();
                } else if (position == 8) {
                    Log.i("hello", "Florida");
                    Toast.makeText(getContext(), "Florida", Toast.LENGTH_SHORT).show();
                } else if (position == 9) {
                    Log.i("hello", "Georgia");
                    Toast.makeText(getContext(), "Georgia", Toast.LENGTH_SHORT).show();
                } else if (position == 10) {
                    Log.i("hello", "Hawaii");
                    Toast.makeText(getContext(), "Hawaii", Toast.LENGTH_SHORT).show();
                } else if (position == 11) {
                    Log.i("hello", "Idaho");
                    Toast.makeText(getContext(), "Idaho", Toast.LENGTH_SHORT).show();
                } else if (position == 12) {
                    Log.i("hello", "Illinois");
                    Toast.makeText(getContext(), "Illinois", Toast.LENGTH_SHORT).show();
                } else if (position == 13) {
                    Log.i("hello", "Indiana");
                    Toast.makeText(getContext(), "Indiana", Toast.LENGTH_SHORT).show();
                } else if (position == 14) {
                    Log.i("hello", "Iowa");
                    Toast.makeText(getContext(), "Iowa", Toast.LENGTH_SHORT).show();
                } else if (position == 15) {
                    Intent mapsActivite = new Intent(getActivity(), MapsActivity.class);
                    startActivity(mapsActivite);
                }
            }
        });
        return rootView;
    }
}
