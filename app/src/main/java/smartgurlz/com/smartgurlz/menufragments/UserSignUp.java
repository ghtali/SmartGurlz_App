package smartgurlz.com.smartgurlz.menufragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import smartgurlz.com.smartgurlz.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserSignUp extends Fragment {

    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText getEditTextPassword;
    private TextView textViewSignIn;
    private FirebaseAuth firebaseAuth;





    public UserSignUp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


            firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null){

            UserProfile userProfile = new UserProfile();
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.userprofileLayout, userProfile).commit();

            buttonRegister = getView().findViewById(R.id.buttonRegister);

            editTextEmail =  getView().findViewById(R.id.editTextEmail);

            getEditTextPassword =  getView().findViewById(R.id.editTextPassword);

            textViewSignIn = getView().findViewById(R.id.textViewSignIn);

            buttonRegister.setOnClickListener((View.OnClickListener) this);

            textViewSignIn.setOnClickListener((View.OnClickListener) this);

        }

        return inflater.inflate(R.layout.fragment_user_sign_up, container, false);


    }


}
