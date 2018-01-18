package smartgurlz.com.smartgurlz;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import smartgurlz.com.smartgurlz.menufragments.FragmentFour;
import smartgurlz.com.smartgurlz.menufragments.FragmentThree;
import smartgurlz.com.smartgurlz.menufragments.FragmentTwo;
//import smartgurlz.com.smartgurlz.menufragments.LevelFragment;
import smartgurlz.com.smartgurlz.menufragments.LevelSelect;
//import smartgurlz.com.smartgurlz.menufragments.dummy.DummyContent;

/**@author Flemming & Ali & Abdi & Ana-Maria & Mads
 *
 */

public class MainMenu extends AppCompatActivity implements LevelSelect.OnListFragmentInteractionListener{

    private TextView mTextMessage;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {



        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {




            //Switch to select menufragments
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitle("LevelSelect");
                    LevelSelect fragment= new LevelSelect();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container, fragment, "Fragm1"); // container is the id of Layout in xml file()
                    fragmentTransaction.commit();// remember to commit fragment

                    // Set view to Welcomescreen to gone, making it non-selectable
                    //findViewById(R.id.navigation_welcome).setVisibility(View.GONE);
                    return true;
                case R.id.navigation_dashboard:
                    setTitle("Fragment Title Two");
                    FragmentTwo fragment2 = new FragmentTwo();

                   // LoginFragment fragment2 = new LoginFragment();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.container, fragment2 , "Frag2");  // container is the id of Layout in xml file()
                    fragmentTransaction2.commit();

                    return true;
                case R.id.navigation_notifications:
                    setTitle("Fragment Three");
                    FragmentThree fragment3 = new FragmentThree();
                    FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.container, fragment3, "Frag3"); // container is the id of Layout in xml file()
                    fragmentTransaction3.commit();

                    return true;
                case R.id.navigation_welcome:
                    setTitle("Welcome Fragment");
                    FragmentFour fragment4 = new FragmentFour();
                    FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction4.replace(R.id.container, fragment4, "Frag4"); // container is the id of Layout in xml file()
                    fragmentTransaction4.commit();

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

        //Changes the bottom navigtion menu items
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
        for (int i = 0; i < menuView.getChildCount(); i++) {
            final View iconView = menuView.getChildAt(i).findViewById(android.support.design.R.id.icon);
            final ViewGroup.LayoutParams layoutParams = iconView.getLayoutParams();
            final DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            // New size 40 is set on icons
            layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, displayMetrics);
            // New size 40 is set on icons
            layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, displayMetrics);
            iconView.setLayoutParams(layoutParams);
        }

      //  BottomNavigationView bottomNavigation = new BottomNavigationView;
        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
      //  bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);


        //When app starts Welcome Fragment will be displayed until other option is chosen
        setTitle("Welcome Fragment");
        FragmentFour fragment = new FragmentFour();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, "FragmentName"); // fram is the id of FrameLayout in xml file()
        fragmentTransaction.commit();
        // Set view to Welcomescreen to View.GONE,
        // making it invisible and non-selectable
        findViewById(R.id.navigation_welcome).setVisibility(View.GONE);
    }

//    @Override
//    public void onListFragmentInteraction(DummyContent.DummyItem item) {
//
//    }
}