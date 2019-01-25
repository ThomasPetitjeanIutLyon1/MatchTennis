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
        pts.add("0");
        pts.add("15");
        pts.add("30");
        pts.add("40");
        pts.add("A");
    }

    public void winPts(Player player){
        Player winPlayer = player;
        Player loosePlayer = getLooser(winPlayer);

        if(findScore(winPlayer.getPoints()) == 4 && findScore(loosePlayer.getPoints()) < 4){
            winnedSet.add(winPlayer);
        }
        else if (findScore(winPlayer.getPoints()) < 4){
            winPlayer.setPoints(pts.get(findScore(winPlayer.getPoints())+1));
        }

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
