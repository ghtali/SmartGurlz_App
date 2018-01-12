package smartgurlz.com.smartgurlz.control;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ali on 12/01/2018.
 */

@IgnoreExtraProperties
public class ScoreControl {

    public String levels;
    public String levelNumbers;
    public String scores;
    public String bronze;
    public String gold;
    public String highScore;
    public String silver;

    public int starCount = 0;
    public Map<String, Boolean> stars = new HashMap<>();

    public ScoreControl() {
        // Default constructor required for calls to DataSnapshot.getValue(ScoreControl.class)
    }

    public ScoreControl(String levels, String levelNumbers, String scores, String bronze, String gold, String highScore, String silver) {
        this.levels = levels;
        this.levelNumbers = levelNumbers;
        this.scores = scores;
        this.bronze = bronze;
        this.gold = gold;
        this.highScore = highScore;
        this.silver = silver;
    }

    @Exclude
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("levels", new Long(levels));
        result.put("levelNumbers", new Long(levelNumbers));
        result.put("scores", new Long(scores));
        result.put("gold", new Long(gold));
        result.put("highScore", new Long(highScore));
        result.put("silver", new Long(silver));

        return result;
    }

}