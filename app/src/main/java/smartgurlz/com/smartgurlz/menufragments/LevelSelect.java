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
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import smartgurlz.com.smartgurlz.CustomListAdapter;
import smartgurlz.com.smartgurlz.R;
import smartgurlz.com.smartgurlz.WelcomeActivity;

/**@author Abdi & Mads 12-01-18
 * A simple {@link Fragment} subclass.
 */
public class LevelSelect extends Fragment implements AdapterView.OnItemClickListener {

     TextView  leveltext;
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

            "1", "2","3", "4",
            "5", "6", "7", "8",
           "9", "10","11", "12",

    };

    public LevelSelect() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate( R.layout.fragment_level_select, container, false );

       // listView = ( ListView ) view.findViewById( R.id.levelList );

           leveltext= (TextView) view.findViewById( R.id.leveltext );
        imageView = ( ImageView ) view.findViewById( R.id.icon );
        gridView2= (GridView) view.findViewById( R.id.gridView2 );


                ;CustomListAdapter adapter = new CustomListAdapter( getActivity(), listRank, imgid);

        gridView2.setAdapter( adapter );


        gridView2.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {

                if (position == 0 ){

                    startActivity( new Intent( getActivity().getApplicationContext(), WelcomeActivity.class ) );

                }
                else {

                    Toast.makeText( getActivity(),"level låst"+"\nDu har ikke nok point ", Toast.LENGTH_LONG ).show();
                }


            }

        } );


        return view;
    }

    @Override
    public void onItemClick(AdapterView <?> parent, View view, int position, long id) {



        }
    }
                                                                                                        