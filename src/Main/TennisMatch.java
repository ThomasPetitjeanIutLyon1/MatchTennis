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
        setManager = new SetManager(this.player1,this.player2,this.tieBreakInLastSet,matchType);
    }



    public String pointsForPlayer(Player player){
        return player.getPoints();
    }

    public void updateWithPointWonBy(Player player){
        if (player1.getGameInSet().size() != matchType.numberOfSetsToWin()){
            setManager.winPts(player);
        }
        else {
            this.isGameFinnished = true;
        }

    }

    public int currentSetNumber(){
        return player1.getGameInSet().size() + 1;
    }

    public int gamesInSetForPlayer(int setNumber,Player player){
      return player.getWinnedGamesInSets(setNumber);
    }

    public int getEndedSet(){
        return player1.getGameInSet().size();
    }

    public int gamesInCurrentSetForPlayer(Player player){
        return player.getGameWinned();
    }

    public boolean isFinnished(){
        return getIsGameFinnished();
    }

    private boolean getIsGameFinnished() {
        return isGameFinnished;
    }
}
