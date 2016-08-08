package sn.pineapple.www.stateslistproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    private class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_states, container, false);

            final String[] states = {"Alabama", "Alaska", "Arizona ", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii",
                    "Idaho", "Illinois Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri",
                    "Montana", "Hawaii", "New York", "Washinton DC", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New York", " New Mexico", " Ohio ", "Texas ",
                    " North Carolina", "North Dakota ", " Oklahoma", "Oregon ", " Pennsylvania Rhode Island ", "South Carolina ", " South Dakota", "Tennessee ",
                    "  Utah", " Vermont ", "  Virginia", "Washington ", " West Virginia", "Wisconsin", " Wyoming"};

            ArrayAdapter<String> peopleAdapter = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_1,
                    states);
            ListView lv1 = (ListView) rootView.findViewById(R.id.listStates);
            lv1.setAdapter(peopleAdapter);


            lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {


                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                    for (int i = 0; i < states.length; i++) {
                        if (position == 40) {
                            startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                        }
                    }
                }

            });

            return rootView;
        }
    }


}
