import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;

public class SetManager {
    private Player player1;
    private Player player2;
    private boolean tieBreakInLastSet;



    private ArrayList<String> pts = new ArrayList<>();
    private ArrayList<Player> winnedSet = new ArrayList<>();


    public SetManager(Player player1, Player player2, boolean tieBreakInLastSet) {
        this.player1 = player1;
        this.player2 = player2;
        this.tieBreakInLastSet = tieBreakInLastSet;

        initPts();
    }

    private void initPts(){
        pts.add("0");   //0
        pts.add("15");   //1
        pts.add("30");   //2
        pts.add("40");   //3
        pts.add("A");   //4
    }

    public void winPts(Player player){
        Player winPlayer = player;
        Player loosePlayer = getLooser(winPlayer);

        if (!isGameWinned(winPlayer,loosePlayer)){
            if (findScore(winPlayer.getPoints()) < 3 && findScore(loosePlayer.getPoints()) != 4){
                winPlayer.setPoints(pts.get(findScore(winPlayer.getPoints())+1));
            }
            else if (findScore(winPlayer.getPoints()) == findScore(loosePlayer.getPoints()) && findScore(winPlayer.getPoints()) == 3){
                winPlayer.setPoints("A");
            }
            else if (findScore(loosePlayer.getPoints()) == 4){
                loosePlayer.setPoints("40");
                winPlayer.setPoints("A");
            }
        }


    }

    private boolean isGameWinned(Player winPlayer, Player loosePlayer){
        if(findScore(winPlayer.getPoints()) == 3 && findScore(loosePlayer.getPoints()) < 3){
            winPlayer.setGameWinned(winPlayer.getGameWinned()+1);
            winPlayer.setPoints("0");
            loosePlayer.setPoints("0");
            isSetWinned(winPlayer,loosePlayer);
            return true;
        }
        else if (findScore(winPlayer.getPoints()) == 4 && findScore(loosePlayer.getPoints()) == 3){
            winPlayer.setGameWinned(winPlayer.getGameWinned()+1);
            winPlayer.setPoints("0");
            loosePlayer.setPoints("0");
            isSetWinned(winPlayer,loosePlayer);
            return true;
        }
        return false;
    }

    private boolean isSetWinned(Player winPlayer, Player loosePlayer){
        if(tieBreakInLastSet){
            if (winPlayer.getGameWinned() == 6 && loosePlayer.getGameWinned() <= 4){
                winPlayer.endSet();
                loosePlayer.endSet();
                return true;
            }
            else if (winPlayer.getGameWinned() == 7 && loosePlayer.getGameWinned() <= 5){
                winPlayer.endSet();
                loosePlayer.endSet();
                return true;
            }
            else if (winPlayer.getGameWinned() == loosePlayer.getGameWinned() && loosePlayer.getGameWinned() == 6){
                int tiebreak = 1;
                return false;
            }
        }
        else {
            if (winPlayer.getGameWinned() >= loosePlayer.getGameWinned()+2 && winPlayer.getGameWinned() >= 6){
                winPlayer.endSet();
                loosePlayer.endSet();
                return true;
            }
        }
        return false;

    }

    private Player getLooser(Player winPlayer){
        if(winPlayer == player1){
            return player2;
        }
        else {
            return player1;
        }
    }

    private int findScore(String score){
        for (int i = 0; i< pts.size();i++){
            if(pts.get(i) == score){
                return i;
            }
        }
       return -1;
    }
}
