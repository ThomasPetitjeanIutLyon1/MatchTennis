public class TennisMatch {

    private Player player1;
    private Player player2;
    private MatchType matchType;
    private boolean tieBreakInLastSet;
    private boolean isGameFinnished;

    private SetManager setManager;

    public TennisMatch(Player player1,Player player2, MatchType matchType, boolean tieBreakInLastSet) {
        this.player1 = player1;
        this.player2 = player2;
        this.isGameFinnished = false;
        this.matchType = matchType;
        this.tieBreakInLastSet = tieBreakInLastSet;
        setManager = new SetManager(this.player1,this.player2,this.tieBreakInLastSet);
    }

    public void updateWithPointWonBy(Player player){

    }

    public String pointsForPlayer(Player player){
        return player.getPoints();
    }

    public void playerWinPoint(Player player){
        setManager.winPts(player);
    }

    public int curretnSetNumber(){
        return 0;
    }

    public int gamesInSetForPlyer(int setNumber,Player player){
        return 0;
    }



    public int gamesInCurrentSetForPlayer(Player player){
        return player.getWinnedGamesInSets();
    }

    public boolean isFinnished(){
        return getIsGameFinnished();
    }

    private boolean getIsGameFinnished() {
        return isGameFinnished;
    }
}
