package smartgurlz.com.smartgurlz.menufragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import smartgurlz.com.smartgurlz.CustomListAdapter;
import smartgurlz.com.smartgurlz.R;
import smartgurlz.com.smartgurlz.WelcomeActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class LevelSelect extends Fragment implements AdapterView.OnItemClickListener {

     TextView  leveltext;
    ListView listView;
    ImageView imageView;
    Integer[] imgid = new Integer[]{
            R.drawable.lvl1, R.drawable.lock,
            R.drawable.lock, R.drawable.lock,
            R.drawable.lock, R.drawable.lock,
            R.drawable.lock, R.drawable.lock,
            R.drawable.lock, R.drawable.lock,
             /* R.drawable.lock, R.drawable.lock,
            R.drawable.lock, R.drawable.lock,
            R.drawable.lock, R.drawable.lock,
            R.drawable.lock, R.drawable.lock,
            R.drawable.lock, R.drawable.lock,*/


    };
    String[] listRank = new String[]{

            "1", "2",
            "3", "4",
            "5", "6",
            "7", "8",

    };

    public LevelSelect() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate( R.layout.fragment_level_select, container, false );

        listView = ( ListView ) view.findViewById( R.id.levelList );

           leveltext= (TextView) view.findViewById( R.id.leveltext );
        imageView = ( ImageView ) view.findViewById( R.id.icon );

                ;CustomListAdapter adapter = new CustomListAdapter( getActivity(), listRank, imgid);

        listView.setAdapter( adapter );


        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {

                if (position !=0 ){

                    Toast.makeText( getActivity(),"level låst" , Toast.LENGTH_LONG ).show();

                }
                else {
                    startActivity( new Intent( getActivity().getApplicationContext(), WelcomeActivity.class ) );

                }


            }

        } );


        return view;
    }

    @Override
    public void onItemClick(AdapterView <?> parent, View view, int position, long id) {



        }
    }
                                                                                                        