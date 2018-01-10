package smartgurlz.com.smartgurlz.menufragments;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import smartgurlz.com.smartgurlz.R;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class FragmentOne extends Fragment {

    private GridView gridView;
    private ArrayAdapter adapter;

    private static String[] ar = {"1", "2", "3"};

    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate( R.layout.fragment_fragment_one, null );

        //REFERENCE
        gridView=(GridView) v.findViewById( R.id.gridview1 );

        //Adopter
        gridView.setAdapter( new ArrayAdapter<String> (getActivity(),android.R.layout.simple_list_item_1,ar  ));

        //item clicks
        gridView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int i, long id) {
                Toast.makeText( getActivity(),ar[i],Toast.LENGTH_SHORT ).show();

            }
        } );
        return v;

    }
    public String[] tostring(){
        return ar ;
    }
}





