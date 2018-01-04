package smartgurlz.com.smartgurlz;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import smartgurlz.com.smartgurlz.MenusFragments.FragmentOne;
import smartgurlz.com.smartgurlz.MenusFragments.FragmentThree;
import smartgurlz.com.smartgurlz.MenusFragments.FragmentTwo;

public class MainMenu extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitle("Fragment Title One");
                    FragmentOne fragment = new FragmentOne();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fram, fragment, "FragmentName"); // fram is the id of FrameLayout in xml file()
                    fragmentTransaction.commit();// remember to commit fragment
                    return true;
                case R.id.navigation_dashboard:
                    setTitle("Fragment Title Two");
                    FragmentTwo fragment2 = new FragmentTwo();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.fram, fragment2 , "FragmentName"); // fram is the id of FrameLayout in xml file()
                    fragmentTransaction2.commit();
                    return true;
                case R.id.navigation_notifications:
                    setTitle("Fragment Three");
                    FragmentThree fragment3 = new FragmentThree();
                    FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.fram, fragment3, "FragmentName"); // fram is the id of FrameLayout in xml file()
                    fragmentTransaction3.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //When app starts FragmentOne will be displayed
        setTitle("Fragment Title One");
        FragmentOne fragment = new FragmentOne();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fram, fragment, "FragmentName"); // fram is the id of FrameLayout in xml file()
        fragmentTransaction.commit();
    }

}