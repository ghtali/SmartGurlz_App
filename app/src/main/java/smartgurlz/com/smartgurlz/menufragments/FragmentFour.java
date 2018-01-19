package smartgurlz.com.smartgurlz.menufragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import smartgurlz.com.smartgurlz.R;

/**@author Flemming
 *
 */

public class FragmentFour extends Fragment {

    public FragmentFour() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_fragment_four, container, false);

        return view;
    }
}
