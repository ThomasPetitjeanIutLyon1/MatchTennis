

public class TennisSet {



    private String Pts;
    private int games;
    private int winnedSet;
    private int numberOfSetToWin;
    private int currentSet;

    public TennisSet() {
        Pts = "0";
        winnedSet = 0;
        currentSet = 0;
    }

    public String getPts() {
        return Pts;
    }

    public void setPts(String pts) {
        Pts = pts;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getWinnedSet() {
        return winnedSet;
    }

    public void setWinnedSet(int winnedSet) {
        this.winnedSet = winnedSet;
    }

    public int getNumberOfSetToWin() {
        return numberOfSetToWin;
    }

    public void setNumberOfSetToWin(int numberOfSetToWin) {
        this.numberOfSetToWin = numberOfSetToWin;
    }

    public int getCurrentSet() {
        return currentSet;
    }

    public void setCurrentSet(int currentSet) {
        this.currentSet = currentSet;
    }
}
