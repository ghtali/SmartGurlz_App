package smartgurlz.com.smartgurlz.menufragments;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

import smartgurlz.com.smartgurlz.MainMenu;
import smartgurlz.com.smartgurlz.R;

//import smartgurlz.com.smartgurlz.MenuActivity;

/**@author Mads & Ana-Maria 10-01-18
 * A simple {@link Fragment} subclass.
 *
 */
public class FragmentTwo extends Fragment  {

    private EditText username_input;
    private EditText password_input;
    private Button login_btn;
    private Button signup_btn;
    private TextView forgotPassword;
    private FirebaseAuth auth;
    private FrameLayout login_fID;
  //  private  Snackbar snackbar;
  //  private ImageButton back_btn;

    public FragmentTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // View view = inflater.inflate(R.layout.fragment_login, container, false);
        View view = inflater.inflate(R.layout.fragment_fragment_two, container, false);




        username_input = (EditText) view.findViewById(R.id.userName_etx);
        password_input = (EditText) view.findViewById(R.id.passWord_etx);

        login_btn = (Button) view.findViewById(R.id.login_btn);
        signup_btn = (Button) view.findViewById(R.id.signup_btn);
        forgotPassword = (TextView) view.findViewById(R.id.forgotPassword);

        login_fID = (FrameLayout) view.findViewById(R.id.login_fID);

      //  back_btn = (ImageButton) view.findViewById(R.id.backb_btn);

        // Init Firebase Auth
        auth = FirebaseAuth.getInstance();

        //Should make sure that, if a user is logged in, they are on the userProfile
        if (auth.getCurrentUser() != null) {
            UserProfile profileFrag = new UserProfile();
            FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
            fragmentTransaction2.replace(R.id.container, profileFrag, "FragmentName"); // fram is the id of FrameLayout in xml file()
            fragmentTransaction2.commit();
        }



        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                loginUser();


                /*
               // SharedPreferences sharedPref = getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
               // String name = sharedPref.getString("username", "");
               // String pw = sharedPref.getString("password", "");
                if(username_input.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Enter your email", Toast.LENGTH_SHORT).show();
                }
                if(password_input.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Enter your password", Toast.LENGTH_SHORT).show();
                }
                else  {

                   // loginUser(username_input.getText().toString().trim(), password_input.getText().toString().trim());
                    //Toast.makeText(getActivity(), "Welcome " + user.getDisplayName().toString(), Toast.LENGTH_SHORT).show();
                    username_input.getText().clear();
                    password_input.getText().clear();
                }

                if (user != null) {
                    // User is signed in
                    Toast.makeText(getActivity(), "Welcome " + user.getDisplayName().toString(), Toast.LENGTH_SHORT).show();

                } else {
                    // No user is signed in
                    Toast.makeText(getActivity(), "Already logged in", Toast.LENGTH_SHORT).show();
                } */

                /*
                //Checks if the password and username is correct. Redirects to the menu if correct.
                if (username_input.getText().toString().equals(name) &&
                        password_input.getText().toString().equals(pw)) {
                    Toast.makeText(getActivity().getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getActivity(), MainMenu.class);
                    startActivity(i);
                    getActivity().finish();

                    //Or a toast will tell the user that it is wrong
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "Wrong username or password", Toast.LENGTH_LONG).show();


                }
                */
            }
        });
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("username", username_input.getText().toString());
                editor.putString("password", password_input.getText().toString());
                editor.apply();

                //Toast.makeText(getActivity().getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();

                //so the password and username clears from the screen.
               // username_input.getText().clear();
               // password_input.getText().clear();

                UserSignUp fragsignup = new UserSignUp();

                FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.container, fragsignup , "FragmentName"); // fram is the id of FrameLayout in xml file()
                fragmentTransaction2.commit();

            }
        });
       /* back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MenuActivity.class);
                startActivity(i);
                getActivity().finish();
            }
        });
*/

       forgotPassword.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              //  loginUser("Hej","123");
               ForgotPass_Frag forgotPassword = new ForgotPass_Frag();

               FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
               fragmentTransaction2.replace(R.id.container, forgotPassword, "FragmentName");
               fragmentTransaction2.commit();


           }

       });

        // Inflate the layout for this fragment

       //return inflater.inflate(R.layout.fragment_fragment_two, container, false);
        return view;
    }
    private  void loginUser() {
        String email = username_input.getText().toString().trim();
        String password = password_input.getText().toString().trim();

        //email can't be empty
        if (email.isEmpty()) {

            username_input.setError("Email is required");
            username_input.requestFocus();
            return;

        }
        //Is it a legit email address
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            username_input.setError("Please enter a valid email");
            username_input.requestFocus();
            return;
        }
        //password can't be empty
        if (password.isEmpty()) {

            password_input.setError("Password is required");
            password_input.requestFocus();
            return;

        }
        if(password.length()<6){
           password_input.setError("Minimum passwordlength should be 6 characters");
            password_input.requestFocus();
            return;
        }
        auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {

                    /*//Fjern denne if og else løkke
                    if (password.length() < 6) {
                       Snackbar snackbar = Snackbar.make(login_fID, "Password is less than 6 characters long", Snackbar.LENGTH_SHORT);
                        snackbar.show();*/
                   // }
                   // else {
                        Snackbar snackbar = Snackbar.make(login_fID, "Email or password is incorrect", Snackbar.LENGTH_SHORT);
                        snackbar.show();
                        //startActivity(new Intent(getActivity(), MainMenu.class));
                        //getActivity().finish();
                    }

                else if (task.isSuccessful()){
                    FirebaseUser user = auth.getCurrentUser();
                    Toast.makeText(getActivity(), "A great person has logged in!", Toast.LENGTH_LONG).show();

                    UserProfile userprofile = new UserProfile();
                    FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.container, userprofile, "FragmentName");
                    fragmentTransaction2.commit();


                }
            }
        });

    }

}
