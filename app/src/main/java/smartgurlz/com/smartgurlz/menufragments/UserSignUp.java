package smartgurlz.com.smartgurlz.menufragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.Executor;

import smartgurlz.com.smartgurlz.MainMenu;
import smartgurlz.com.smartgurlz.R;
import smartgurlz.com.smartgurlz.control.UserControl;

/**@author Mads & Ana-Maria 10-01-18
 * A simple {@link Fragment} subclass.
 */
public class UserSignUp extends Fragment {

    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText getEditTextPassword;
    private FirebaseAuth firebaseAuth;
    private TextView already_txt;
    private EditText username_edt;
    private DatabaseReference mDatabase;
    private String displayName;

    public UserSignUp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_sign_up, container, false);

        firebaseAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        buttonRegister = (Button) view.findViewById(R.id.buttonRegister);

        editTextEmail = (EditText) view.findViewById(R.id.editTextEmail);

        getEditTextPassword = (EditText) view.findViewById(R.id.editTextPassword);

        already_txt = (TextView) view.findViewById(R.id.already_txt);

        username_edt = (EditText) view.findViewById(R.id.username_edt);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();

                editTextEmail.getText().clear();
                getEditTextPassword.getText().clear();


            }
        });


        already_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTwo loginfrag = new FragmentTwo();

                FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.container, loginfrag, "FragmentName"); // fram is the id of FrameLayout in xml file()
                fragmentTransaction2.commit();


            }

        });


        return view;

    }


        private void registerUser() {
            String email = editTextEmail.getText().toString().trim();
            String password = getEditTextPassword.getText().toString().trim();

            //email can't be empty
            if (email.isEmpty()) {

                editTextEmail.setError("Email is required");
                editTextEmail.requestFocus();
                return;

            }
            //Is it a legit email address
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                editTextEmail.setError("Please enter a valid email");
                editTextEmail.requestFocus();
                return;
            }
            //password can't be empty
            if (password.isEmpty()) {

                getEditTextPassword.setError("Password is required");
                getEditTextPassword.requestFocus();
                return;

            }
            if(password.length()<6){
                getEditTextPassword.setError("Minimum passwordlength should be 6 characters");
                getEditTextPassword.requestFocus();
                return;
            }

            if(password.length() >= 25){
                getEditTextPassword.setError("The maximum password length is 25 characters long");
                getEditTextPassword.requestFocus();
                return;
            }


        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                       // saveUsername();
                        if (!task.isSuccessful()) {
                            //user is successfully registered
                            //we will start the profile activity here
                            //show the user a message with Toast

                            // If the user is already registered, an exception is thrown
                            if(task.getException() instanceof FirebaseAuthUserCollisionException){
                                Toast.makeText(getActivity(), "This email is already registered",Toast.LENGTH_SHORT ).show();
                            } else{
                                Log.d("ERROR", "Error" + task.getException());
                                Toast.makeText(getActivity().getApplicationContext(), "Oops! Something went wrong - please try again", Toast.LENGTH_LONG).show();
                            }

                        } else {
                            Toast.makeText(getActivity().getApplicationContext(), "Thanks for signing up!", Toast.LENGTH_LONG).show();
                            saveUsername();
                            username_edt.getText().clear();
                        }
                    }
                });

    }

    private void saveUsername(){
        displayName = username_edt.getText().toString().trim();

        if(displayName.isEmpty()){
            username_edt.setError("Name required");
            username_edt.requestFocus();
            return;
        }

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            UserProfileChangeRequest profile = new UserProfileChangeRequest.Builder()
                    .setDisplayName(displayName)
                    .build();

            user.updateProfile(profile)
            .addOnCompleteListener(new OnCompleteListener <Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                       Toast.makeText(getActivity(), "username saved", Toast.LENGTH_SHORT).show();
                        Log.d("Success", "user profile updated " + displayName);
                    }else{
                        Toast.makeText(getActivity(), "username not saved", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }



}