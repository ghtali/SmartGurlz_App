package smartgurlz.com.smartgurlz.control;

/**
 * Created by Ana-Maria on 12-01-2018.
 */

public class UserControl {

    public String username;
   // public String email;


    public UserControl() {
        // Required empty public constructor
    }

    public UserControl(String username) {
        this.username = username;
        //this.email = email;
    }

    //Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
   /*
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }*/
}

