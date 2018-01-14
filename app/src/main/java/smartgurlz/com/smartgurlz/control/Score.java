package smartgurlz.com.smartgurlz.control;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;


@IgnoreExtraProperties
public class Score {
    private String gold;
    private String silver;
    private String bronze;
    private String highScore;

    public Score(){
        //Log.i("Gold from Score class", String.valueOf(getGold()));
        // FirebaseHandler firebaseHandler = new FirebaseHandler();
        //gold = firebaseHandler.


    }

    public Score(String gold, String silver, String bronze, String highScore) {
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.highScore = highScore;
    }

    @Exclude
    public HashMap<String, String> toMap() {
        HashMap<String, String> result = new HashMap<>();
        result.put("HighScore", highScore);
        result.put("Gold", gold);
        result.put("Silver", silver);
        result.put("Bronze", bronze);

        return result;
    }

    public String getGold() {
        return gold;
    }

    public String getSilver() {
        return silver;
    }

    public String getBronze() {
        return bronze;
    }

    public String getHighScore() {
        return highScore;
    }
}

