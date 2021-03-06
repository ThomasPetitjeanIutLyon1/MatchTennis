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



            setManager.winPts(player);


            this.isGameFinnished = this.gameIsItFinnished();


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
        return this.isGameFinnished;
    }

    private boolean gameIsItFinnished() {
        int nbOfSetToWin;
        switch (matchType){
            case BEST_OF_THREE:
                nbOfSetToWin = 3;
                break;
            case BEST_OF_FIVE:
                nbOfSetToWin = 5;
                break;
            default:
                nbOfSetToWin = 0;
        }

        if (player1.getGameInSet().size() == nbOfSetToWin){
            return true;
        }
        return false;
    }
}
