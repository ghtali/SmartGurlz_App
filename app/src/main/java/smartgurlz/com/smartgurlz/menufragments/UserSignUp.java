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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

    public UserSignUp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_sign_up, container, false);

        firebaseAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("userID");

        username_edt = (EditText) view.findViewById(R.id.username_edt);

        //Toast.makeText(getActivity().getApplicationContext(), "Vi kommer ind", Toast.LENGTH_LONG).show();

        // if (firebaseAuth.getCurrentUser() != null) {

        //UserProfile userProfile = new UserProfile();
        //FragmentManager fragmentManager = getFragmentManager();
        //fragmentManager.beginTransaction().replace(R.id.userprofileLayout, userProfile).commit();


        buttonRegister = (Button) view.findViewById(R.id.buttonRegister);

        editTextEmail = (EditText) view.findViewById(R.id.editTextEmail);

        getEditTextPassword = (EditText) view.findViewById(R.id.editTextPassword);

        // textViewSignIn = (TextView) view.findViewById(R.id.textViewSignIn);

        already_txt = (TextView) view.findViewById(R.id.already_txt);

        //buttonRegister.setOnClickListener((View.OnClickListener) this);

        // textViewSignIn.setOnClickListener((View.OnClickListener) this);


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editTextEmail.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Please enter your email", Toast.LENGTH_LONG).show();
                }
                if(getEditTextPassword.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Please enter your password", Toast.LENGTH_LONG).show();
                }
                else {
                    generateUser();
                    registerUser(editTextEmail.getText().toString().trim(), getEditTextPassword.getText().toString().trim());
                    editTextEmail.getText().clear();
                    getEditTextPassword.getText().clear();
                    username_edt.getText().clear();
                }

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

        //}
/*
        final Button loginButton = (Button)findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredEmail = emailInput.getText().toString();
                String enteredPassword = passwordInput.getText().toString();

                if(TextUtils.isEmpty(enteredEmail) || TextUtils.isEmpty(enteredPassword)){
                    Helper.displayMessageToast(SignUpActivity.this, "Login fields must be filled");
                    return;
                }
                if(!Helper.isValidEmail(enteredEmail)){
                    Helper.displayMessageToast(SignUpActivity.this, "Invalidate email entered");
                    return;
                }

                ((FirebaseApplication)getApplication()).createNewUser(SignUpActivity.this, enteredEmail, enteredPassword, loginError);
            }
        });
    }
    */

        // return inflater.inflate(R.layout.fragment_user_sign_up, container, false);
        return view;

    }

    private void registerUser(String email, String password) {


        if (TextUtils.isEmpty(email)) {
            //email is empty
          //  Toast.makeText(getActivity(),"Please enter your email!", Toast.LENGTH_LONG).show();
            //Stop the function from executing further
            //  return null;

        }
        if (TextUtils.isEmpty(password)) {
            //password is empty
          //  Toast.makeText(getActivity(), "Please enter password", Toast.LENGTH_LONG).show();
            //Stop the function from executing further
            // return null;
        }

        //if validations are ok
        //then will first show a progressDialog

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                      //   generateUser(username, email, password);
                        if (!task.isSuccessful()) {
                            //user is successfully registered and logged in
                            //we will start the profile activity here
                            //show the user a message with Toast
                            Log.d("ERROR", "Error" + task.getException());
                            Toast.makeText(getActivity().getApplicationContext(), "ERROR" + task.getException(), Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getActivity().getApplicationContext(), "Registered successfuly!", Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }

    public void generateUser() {
        String username = username_edt.getText().toString().trim();
        UserControl userInformation = new UserControl(username);

        FirebaseUser bruger = firebaseAuth.getCurrentUser();


        mDatabase.child("user").child("userID").child(bruger.getUid()).setValue(userInformation);
        Toast.makeText(getActivity(), "Username saved...", Toast.LENGTH_LONG).show();

       // mDatabase.child("user").child("userID").setValue(userInformation);


           /* FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference user = database.getReference("user");
            UserProfile user = new UserProfile(username, password);
            users.push().setValue(user);*/

    }

}