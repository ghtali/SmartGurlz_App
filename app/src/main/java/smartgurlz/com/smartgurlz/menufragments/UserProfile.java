package smartgurlz.com.smartgurlz.menufragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import smartgurlz.com.smartgurlz.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserProfile extends Fragment {

    private TextView welcome_txt;

    public UserProfile() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);

        welcome_txt = (TextView) view.findViewById(R.id.welcome_txt);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            String name = user.getDisplayName();
            welcome_txt.setText("Welcome: " + name);


        } else {
            // No user is signed in
            welcome_txt.setText("Welcome " + " Anonymous");
        }


        return view;
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_user_profile, container, false);
    }

}
