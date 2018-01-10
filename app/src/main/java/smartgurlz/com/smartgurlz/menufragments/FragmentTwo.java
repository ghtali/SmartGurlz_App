package smartgurlz.com.smartgurlz.menufragments;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
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

import java.util.concurrent.Executor;

import smartgurlz.com.smartgurlz.MainMenu;
import smartgurlz.com.smartgurlz.R;

//import smartgurlz.com.smartgurlz.MenuActivity;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class FragmentTwo extends Fragment {

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

        if (auth.getCurrentUser() != null) {
            //Start aktivity
        }

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SharedPreferences sharedPref = getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                String name = sharedPref.getString("username", "");
                String pw = sharedPref.getString("password", "");

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

                Toast.makeText(getActivity().getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();

                //so the password and username clears from the screen.
                username_input.getText().clear();
                password_input.getText().clear();
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

           }

       });

        // Inflate the layout for this fragment

       return inflater.inflate(R.layout.fragment_fragment_two, container, false);
    }
    private  void loginUser(String email, final String password) {
        auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    if (password.length() < 6) {
                        //Toast.makeText(, "Password is wrong", Toast.LENGTH_LONG).show();
                        Snackbar snackbar = Snackbar.make(login_fID, "had a d", Snackbar.LENGTH_SHORT);
                        snackbar.show();
                    }
                }
            }
        });
    }

}
