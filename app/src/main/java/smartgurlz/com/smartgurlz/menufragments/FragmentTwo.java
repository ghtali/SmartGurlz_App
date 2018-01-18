package smartgurlz.com.smartgurlz.menufragments;



import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
import smartgurlz.com.smartgurlz.R;



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


    public FragmentTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment_two, container, false);




        username_input = (EditText) view.findViewById(R.id.userName_etx);
        password_input = (EditText) view.findViewById(R.id.passWord_etx);

        login_btn = (Button) view.findViewById(R.id.login_btn);
        signup_btn = (Button) view.findViewById(R.id.signup_btn);
        forgotPassword = (TextView) view.findViewById(R.id.forgotPassword);

        login_fID = (FrameLayout) view.findViewById(R.id.login_fID);



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


                loginUser();


            }
        });
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                UserSignUp fragsignup = new UserSignUp();

                FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.container, fragsignup , "FragmentName");
                fragmentTransaction2.commit();

            }
        });

       forgotPassword.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               ForgotPass_Frag forgotPassword = new ForgotPass_Frag();

               FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
               fragmentTransaction2.replace(R.id.container, forgotPassword, "FragmentName");
               fragmentTransaction2.commit();


           }

       });


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
        //password needs to be more than six characters long
        if(password.length()<6){
           password_input.setError("The minimum password length should be at least 6 characters long");
            password_input.requestFocus();
            return;
        }

        if(password.length() >= 25){
            password_input.setError("The maximum password length is 25 characters long");
            password_input.requestFocus();
            return;
        }
        auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {


                        Snackbar snackbar = Snackbar.make(login_fID, "Email or password is incorrect", Snackbar.LENGTH_SHORT);
                        snackbar.show();

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
