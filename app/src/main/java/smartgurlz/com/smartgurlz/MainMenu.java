package smartgurlz.com.smartgurlz;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import smartgurlz.com.smartgurlz.menufragments.FragmentOne;
import smartgurlz.com.smartgurlz.menufragments.FragmentThree;
import smartgurlz.com.smartgurlz.menufragments.FragmentTwo;
import smartgurlz.com.smartgurlz.menufragments.LevelFragment;
import smartgurlz.com.smartgurlz.menufragments.dummy.DummyContent;

public class MainMenu extends AppCompatActivity implements LevelFragment.OnListFragmentInteractionListener{

    private TextView mTextMessage;






    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {



        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

       /*    BottomNavigationView bottomNavigationView = (BottomNavigationView)

            findViewById(R.id.navigation);

            bottomNavigationView.getMenu().findItem(R.id.uncheckedItem).setChecked(true);
            bottomNavigationView.findViewById(R.id.uncheckedItem).setVisibility(View.GONE);

            BottomNavigationViewUtils.disableShiftMode(bottomNavigationView);*/

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitle("LevelFragment");
                    LevelFragment fragment = new LevelFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container, fragment, "FragmentName"); // container is the id of Layout in xml file()
                    fragmentTransaction.commit();// remember to commit fragment
                    return true;
                case R.id.navigation_dashboard:
                    setTitle("Fragment Title Two");
                    FragmentTwo fragment2 = new FragmentTwo();

                   // LoginFragment fragment2 = new LoginFragment();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.container, fragment2 , "FragmentName");  // container is the id of Layout in xml file()
                    fragmentTransaction2.commit();
                    return true;
                case R.id.navigation_notifications:
                    setTitle("Fragment Three");
                    FragmentThree fragment3 = new FragmentThree();
                    FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.container, fragment3, "FragmentName"); // container is the id of Layout in xml file()
                    fragmentTransaction3.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //When app starts FragmentOne will be displayed
        setTitle("LevelFragment");
        LevelFragment fragment = new LevelFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, "FragmentName"); // fram is the id of FrameLayout in xml file()
        fragmentTransaction.commit();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        
    }
}