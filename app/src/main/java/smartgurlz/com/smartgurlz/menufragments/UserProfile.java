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
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

import smartgurlz.com.smartgurlz.R;

/**@author Ana-Maria
 * A simple {@link Fragment} subclass.
 */
public class UserProfile extends Fragment {

    private TextView welcome_txt, deleteUser_txt;
    private Button signOut_btn, changePassword_btn;
    private EditText changePass_txt, emailRe_edt, passRe_edt;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private String newPassword;


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
        changePass_txt = (EditText) view.findViewById(R.id.changePass_txt);
        emailRe_edt = (EditText) view.findViewById(R.id.emailRe_edt);
        passRe_edt = (EditText) view.findViewById(R.id.passRe_edt);
        ScrollView Userprofile=view.findViewById(R.id.userprofileLayout);

        user = FirebaseAuth.getInstance().getCurrentUser();
        mAuth = FirebaseAuth.getInstance();
       // changePass_txt.setVisibility(View.INVISIBLE);



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

                                                  AuthCredential credential = EmailAuthProvider.getCredential(emailRe_edt.getText().toString().trim(), passRe_edt.getText().toString().trim());
                                                  user.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                      @Override
                                                      public void onComplete(@NonNull Task<Void> task) {
                                                          user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                              @Override
                                                              public void onComplete(@NonNull Task<Void> task) {
                                                                  if (task.isSuccessful()) {
                                                                      Toast.makeText(getActivity(), "Your account has been deleted.", Toast.LENGTH_SHORT).show();

                                                                  } else {
                                                                      Toast.makeText(getActivity(), "Error - could not delete your account", Toast.LENGTH_SHORT).show();
                                                                  }
                                                              }
                                                          });
                                                      }
                                                  });
                                              }
                                          });



        changePassword_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                newPassword = changePass_txt.getText().toString().trim();
                AuthCredential credential = EmailAuthProvider.getCredential(emailRe_edt.getText().toString().trim(), passRe_edt.getText().toString().trim());

                user.reauthenticate(credential)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                if (task.isSuccessful()) {
                                    user.updatePassword(newPassword)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (newPassword.length() >= 6) {

                                                        if (task.isSuccessful()) {

                                                            Toast.makeText(getActivity(), "Password updated", Toast.LENGTH_SHORT).show();
                                                            emailRe_edt.getText().clear();
                                                            passRe_edt.getText().clear();
                                                            changePass_txt.getText().clear();
                                                            

                                                        } else {
                                                            Toast.makeText(getActivity(), "Error - password not updated", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }else{
                                                        Toast.makeText(getActivity(),"The minimum password length should be at least 6 characters long", Toast.LENGTH_LONG).show();
                                                    }
                                                } });
                                } else {
                                    Toast.makeText(getActivity(), "Authentication failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

            }else {
            // No user is signed in
            welcome_txt.setText("Welcome " + " Anonymous");
        }


        return view;

    }


}

