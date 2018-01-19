package smartgurlz.com.smartgurlz;

import android.content.Context;
import android.content.SharedPreferences;

/**@author Ali & Flemming
 * Created by Ali on 26/10/2017.
 */

public class PrefManager {

    //Used SharedPreferences to store a boolean value indicating first time launch

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    //Shared pref mode

    int PRIVATE_MODE = 0;

    // Shared preferences file name

    private static final String PREF_NAME = "smartgurlz-welcome";

    private static final String Is_First_Time_Launch = "IsFirstTimeLaunch";

    public PrefManager (Context context){

        this._context = context;

        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);

        editor = pref.edit();

    }

    public void setFirstTimeLaunch(boolean isFirstTime){

        editor.putBoolean(Is_First_Time_Launch, isFirstTime);
        editor.commit();

    }

    public boolean isFirstTimeLaunch(){
        return pref.getBoolean(Is_First_Time_Launch, true);
    }




}
