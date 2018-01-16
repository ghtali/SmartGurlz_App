package smartgurlz.com.smartgurlz.menufragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import smartgurlz.com.smartgurlz.CustomListAdapter;
import smartgurlz.com.smartgurlz.R;
import smartgurlz.com.smartgurlz.WelcomeActivity;

import static android.content.ContentValues.TAG;


/**
 /**@author Abdi & Mads 12-01-18
 * A simple {@link Fragment} subclass.
 */
public class LevelSelect extends Fragment implements AdapterView.OnItemClickListener {

    private ArrayList<String> myList = new ArrayList<>();
    TextView leveltext;
    GridView gridView2;
    ImageView imageView;
    Integer[] imgid = new Integer[]{
            R.drawable.lvl1, R.drawable.lock,
            R.drawable.lock, R.drawable.lock,
            R.drawable.lock, R.drawable.lock,
            R.drawable.lock, R.drawable.lock,
            R.drawable.lock, R.drawable.lock,
            R.drawable.lock, R.drawable.lock,
            R.drawable.lock, R.drawable.lock,
            R.drawable.lock, R.drawable.lock,
            R.drawable.lock, R.drawable.lock,
            R.drawable.lock, R.drawable.lock,


    };
    String[] listRank = new String[]{

            "1", "2", "3", "4",
            "5", "6", "7", "8",
            "9", "10", "11", "12",

    };
//    private LevelSelect levelCount;

    public LevelSelect() {
        // Required empty public constructor
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container2,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_level_select, container2, false);

        // listView = ( ListView ) view.findViewById( R.id.levelList );

        leveltext = view.findViewById(R.id.leveltext);
        imageView = view.findViewById(R.id.icon);
        gridView2 = view.findViewById(R.id.gridView2);
        TextView txtTitle = view.findViewById(R.id.text100);

           leveltext= (TextView) view.findViewById( R.id.leveltext );
        imageView = ( ImageView ) view.findViewById( R.id.icon );
        gridView2= (GridView) view.findViewById( R.id.gridView2 );

        CustomListAdapter adapter = new CustomListAdapter(getActivity(), listRank, imgid);





        gridView2.setAdapter( adapter );
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("Levels").child("LevelNumbers");


        ValueEventListener levelListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {



                myList.add("" + dataSnapshot.getValue());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Score failed, log a message
                Log.w(TAG, "levels:onCancelled", databaseError.toException());
                // ...
            }
        };
        mDatabase.addValueEventListener(levelListener);


        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (myList.size() == 0) return;
                String tekst = myList.get(position);
                System.out.println("Tekst i onItemClick: " + tekst);

                if (tekst.equalsIgnoreCase("1")) {

                    startActivity(new Intent(getActivity().getApplicationContext(), WelcomeActivity.class));

                } else {

                    Toast.makeText(getActivity(), "level låst" + "\nDu har ikke nok point ", Toast.LENGTH_LONG).show();
                }


            }

        });


        return view;
    }

/*    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


    }*/
}
                                                                                                        