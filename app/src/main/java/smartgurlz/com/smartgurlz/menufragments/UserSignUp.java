package smartgurlz.com.smartgurlz.menufragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
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

        if (firebaseAuth.getCurrentUser() != null) {

            UserProfile userProfile = new UserProfile();
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.userprofileLayout, userProfile).commit();

            buttonRegister = getView().findViewById(R.id.buttonRegister);

            editTextEmail = getView().findViewById(R.id.editTextEmail);

            getEditTextPassword = getView().findViewById(R.id.editTextPassword);

            textViewSignIn = getView().findViewById(R.id.textViewSignIn);

            buttonRegister.setOnClickListener((View.OnClickListener) this);

            textViewSignIn.setOnClickListener((View.OnClickListener) this);

        }

        return inflater.inflate(R.layout.fragment_user_sign_up, container, false);

    private void registerUser() {

        String email = editTextEmail.getText().toString().trim();
        String password = getEditTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            //email is empty
            //Toast.makeText("Please Enter Your Email!");
            //Stop the function from executing further
            return;

        }
        if (TextUtils.isEmpty(password)) {
            //password is empty
            //Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
            //Stop the function from executing further
            return;
        }

        //if validations are ok
        //then will first show a progressDialog


        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            //user is successfully registered and logged in
                            //we will start the profile activity here
                            //show the user a message with Toast
                            Toast.makeText(getActivity(this),"Registered successfuly!",Toast.LENGTH_SHORT).show();


                        }
                    }
                });

    }
}
