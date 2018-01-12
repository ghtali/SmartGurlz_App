package smartgurlz.com.smartgurlz.menufragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import smartgurlz.com.smartgurlz.CustomListAdapter;
import smartgurlz.com.smartgurlz.R;
import smartgurlz.com.smartgurlz.WelcomeActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class LevelSelect extends Fragment {
    LinearLayout layout;
    ListView listView;
    ImageView imageView;
    Integer[] data = new Integer[]{
            R.drawable.lvl1, R.drawable.lock,
            R.drawable.lock, R.drawable.lock,
            R.drawable.lock, R.drawable.lock,
            R.drawable.lock, R.drawable.lock,//lvl1
            R.drawable.lock, R.drawable.lock,
            R.drawable.lock, R.drawable.lock,
            R.drawable.lock, R.drawable.lock,
            R.drawable.lock, R.drawable.lock,//lvl1
            R.drawable.lock, R.drawable.lock,
            R.drawable.lock, R.drawable.lock,//lvl changes
            R.drawable.lock, R.drawable.lock

    };
    String[] listRank = new String[]{
            "R.drawable.lvl1", "R.drawable.lock",
            "R.drawable.lock", "R.drawable.lock",
            "R.drawable.lock", "R.drawable.lock",
            "R.drawable.lock", "R.drawable.lock",//lvl1
            "R.drawable.lock", "R.drawable.lock",
            "R.drawable.lock", "R.drawable.lock",
            "R.drawable.lock", "R.drawable.lock",
            "R.drawable.lock", "R.drawable.lock",//lvl1
            "R.drawable.lock", "R.drawable.lock",
            "R.drawable.lock", "R.drawable.lock",//lvl changes
            "R.drawable.lock", "R.drawable.lock"

    };

    public LevelSelect() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate( R.layout.fragment_level_select, container, false );
    layout = view.findViewById( R.id.levelsel );

        listView = (ListView) view.findViewById( R.id.levelList );
        imageView = (ImageView )  view.findViewById( R.id.icon );

        CustomListAdapter adapter=new CustomListAdapter(getActivity(), listRank, data);

        listView.setAdapter( adapter );

        layout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( getActivity().getApplicationContext(), WelcomeActivity.class ) );
            }
        } );

        return view;
    }


}
