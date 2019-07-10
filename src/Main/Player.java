import java.util.ArrayList;

public class Player {
    private  String name;
    private TennisSet tennisSet;
    private String points;
    private int tieBreakPts;
    private int gameWinned;
    private ArrayList<Integer> gameInSet = new ArrayList<>();

    public void setPoints(String points) {
        this.points = points;
    }

    public Player(String name) {
        this.tennisSet = new TennisSet();
        this.name = name;
        this.points = "0";
        this.tieBreakPts = 0;
    }

    public String getPoints(){
        return points;
    }

    public void endSet(){
        gameInSet.add(gameWinned);
        this.points = "0";
        this.gameWinned = 0;
        this.tieBreakPts = 0;
    }

    public int getWinnedGamesInSets(int setNb){
        try {
            return gameInSet.get(setNb);
        }
        catch (Exception e){
            return 0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGameWinned() {
        return gameWinned;
    }

    public void setGameWinned(int gameWinned) {
        this.gameWinned = gameWinned;
    }

    public ArrayList<Integer> getGameInSet() {
        return gameInSet;
    }

    public int getTieBreakPts() {
        return tieBreakPts;
    }

    public void setTieBreakPts(int tieBreakPts) {
        this.tieBreakPts = tieBreakPts;
    }
}
