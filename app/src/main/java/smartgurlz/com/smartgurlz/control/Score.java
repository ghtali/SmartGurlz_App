package smartgurlz.com.smartgurlz.control;

public final class Score{
    private Long gold;
    private Long silver;
    private Long bronze;
    private Long highScore;

    public Score(){

    }

    public Score(Long gold, Long silver, Long bronze, Long highScore) {
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.highScore = highScore;
    }

    public void setGold(Long gold) {
        this.gold = gold;
    }

    public void setSilver(Long silver) {
        this.silver = silver;
    }

    public void setBronze(Long bronze) {
        this.bronze = bronze;
    }

    public void setHighScore(Long highScore) {
        this.highScore = highScore;
    }


    public Long getGold() {
        return gold;
    }

    public Long getSilver() {
        return silver;
    }

    public Long getBronze() {
        return bronze;
    }

    public Long getHighScore() {
        return highScore;
    }

/*    @Exclude
    public Map<Long, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put(String.valueOf("Gold"), gold);
        result.put(String.valueOf("Silver"), silver);
        result.put(String.valueOf("Bronze"), bronze);
        result.put(String.valueOf("HighScore"), highScore);

        return result;
    }*/

}

