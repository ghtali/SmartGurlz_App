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



/**@author Ali & Flemming & Abdi
 * A simple {@link Fragment} subclass.
 *
 */
public class FragmentOne extends Fragment {

    private GridView gridView;
   // private ArrayAdapter adapter;

    private static String[] Levels = {"1", "2", "3"};

    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate( R.layout.fragment_fragment_one, container, false );

        //REFERENCE
        gridView = ( GridView ) v.findViewById( R.id.gridView1 );


        //Adopter


        gridView.setAdapter( new ArrayAdapter<String> (getActivity(),android.R.layout.simple_gallery_item,Levels ));

        //item clicks
        gridView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int i, long id) {

                if (view !=null || gridView==null) return ;

                Toast.makeText( getActivity(),Levels[i],Toast.LENGTH_SHORT ).show();


            }

        } );

        return v;


    }


    public String[] tostring(){
        return Levels;
    }


}





