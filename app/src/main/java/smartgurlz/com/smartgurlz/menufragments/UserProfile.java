package smartgurlz.com.smartgurlz.menufragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

import smartgurlz.com.smartgurlz.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserProfile extends Fragment {

    private TextView welcome_txt, deleteUser_txt;
    private Button signOut_btn, changePassword_btn;
    private FirebaseAuth mAuth;
    private FirebaseUser user;

    public UserProfile() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);

        welcome_txt = (TextView) view.findViewById(R.id.welcome_txt);
        deleteUser_txt = (TextView) view.findViewById(R.id.delete_txt);
        signOut_btn = (Button) view.findViewById(R.id.signOut_btn);
        changePassword_btn = (Button) view.findViewById(R.id.changePassword_btn);

        user = FirebaseAuth.getInstance().getCurrentUser();
        mAuth = FirebaseAuth.getInstance();

        if (user != null) {
            // User is signed in
            String name = user.getDisplayName();
            welcome_txt.setText("Welcome: " + name);

        signOut_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mAuth.signOut();
                Toast.makeText(getActivity(), "You have signed out", Toast.LENGTH_SHORT).show();
                FragmentTwo loginfragt = new FragmentTwo();
                FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.container, loginfragt, "FragmentName"); // fram is the id of FrameLayout in xml file()
                fragmentTransaction2.commit();
            }
        });

        deleteUser_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.delete()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getActivity(), "User account deleted.", Toast.LENGTH_LONG).show();
                                    //Log the user out and goes back to login screen
                                    mAuth.signOut();
                                    FragmentTwo loginfragt = new FragmentTwo();
                                    FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
                                    fragmentTransaction2.replace(R.id.container, loginfragt, "FragmentName"); // fram is the id of FrameLayout in xml file()
                                    fragmentTransaction2.commit();
                                } else{
                                    Toast.makeText(getActivity(), "Error - account not deleted", Toast.LENGTH_LONG).show();
                                }
                            }
                        });

            }
        });

        } else {
            // No user is signed in
            welcome_txt.setText("Welcome " + " Anonymous");
        }


        return view;
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_user_profile, container, false);
    }

}
