import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TennisMatchTest {
    @Test
    public void StartTennisMatch() {
        Player player1 = new Player("Roberto");
        Player player2 = new Player("Theo");
        TennisMatch tennisMatch = new TennisMatch(player1,player2, MatchType.BEST_OF_THREE, true);
        assertFalse(tennisMatch.isFinnished());
        assertEquals("0",tennisMatch.pointsForPlayer(player1));
        assertEquals("0",tennisMatch.pointsForPlayer(player2));
        assertEquals(0,tennisMatch.gamesInCurrentSetForPlayer(player1));
        assertEquals(0,tennisMatch.gamesInCurrentSetForPlayer(player2));

    }

    @Test
    public void PlayerWinPoints() {
        Player player1 = new Player("Roberto");
        Player player2 = new Player("Theo");
        TennisMatch tennisMatch = new TennisMatch(player1,player2, MatchType.BEST_OF_THREE, true);
        assertEquals("Pts","0",tennisMatch.pointsForPlayer(player1));
        assertEquals("Pts","0",tennisMatch.pointsForPlayer(player2));

        tennisMatch.playerWinPoint(player1);
        assertEquals("Pts","15",tennisMatch.pointsForPlayer(player1));
        tennisMatch.playerWinPoint(player1);
        assertEquals("Pts","30",tennisMatch.pointsForPlayer(player1));
        tennisMatch.playerWinPoint(player1);
        assertEquals("Pts","40",tennisMatch.pointsForPlayer(player1));

        tennisMatch.playerWinPoint(player2);
        assertEquals("Pts","15",tennisMatch.pointsForPlayer(player2));
        tennisMatch.playerWinPoint(player2);
        assertEquals("Pts","30",tennisMatch.pointsForPlayer(player2));
        tennisMatch.playerWinPoint(player2);
        assertEquals("Pts","40",tennisMatch.pointsForPlayer(player2));
    }

    @Test
    public void PlayerAdvantage() {
        Player player1 = new Player("Roberto");
        Player player2 = new Player("Theo");
        TennisMatch tennisMatch = new TennisMatch(player1,player2, MatchType.BEST_OF_THREE, true);
        assertEquals("Pts","0",tennisMatch.pointsForPlayer(player1));
        assertEquals("Pts","0",tennisMatch.pointsForPlayer(player2));

        tennisMatch.playerWinPoint(player1);
        tennisMatch.playerWinPoint(player1);
        tennisMatch.playerWinPoint(player1);


        tennisMatch.playerWinPoint(player2);
        tennisMatch.playerWinPoint(player2);
        tennisMatch.playerWinPoint(player2);

        tennisMatch.playerWinPoint(player1);
        assertEquals("Advge","A",tennisMatch.pointsForPlayer(player1));
        assertEquals("Advge","40",tennisMatch.pointsForPlayer(player2));

        tennisMatch.playerWinPoint(player2);
        assertEquals("Advge","40",tennisMatch.pointsForPlayer(player1));
        assertEquals("Advge","A",tennisMatch.pointsForPlayer(player2));

    }

    @Test
    public void PlayerGameWin() {
        Player player1 = new Player("Roberto");
        Player player2 = new Player("Theo");
        TennisMatch tennisMatch = new TennisMatch(player1,player2, MatchType.BEST_OF_THREE, true);
        assertEquals("Pts","0",tennisMatch.pointsForPlayer(player1));
        assertEquals("Pts","0",tennisMatch.pointsForPlayer(player2));

        tennisMatch.playerWinPoint(player1);
        tennisMatch.playerWinPoint(player1);
        tennisMatch.playerWinPoint(player1);


        tennisMatch.playerWinPoint(player1);
        assertEquals("GameWinned",1,tennisMatch.gamesInCurrentSetForPlayer(player1));

        //test si les points recommencent correctement
        tennisMatch.playerWinPoint(player1);
        assertEquals("Pts","15",tennisMatch.pointsForPlayer(player1));
        tennisMatch.playerWinPoint(player1);
        assertEquals("Pts","30",tennisMatch.pointsForPlayer(player1));
        tennisMatch.playerWinPoint(player1);
        assertEquals("Pts","40",tennisMatch.pointsForPlayer(player1));
        tennisMatch.playerWinPoint(player1);
        assertEquals("GameWinned",2,tennisMatch.gamesInCurrentSetForPlayer(player1));

    }

    @Test
    public void PlayerSetWinNoTBSimple() {
        Player player1 = new Player("Roberto");
        Player player2 = new Player("Theo");
        TennisMatch tennisMatch = new TennisMatch(player1,player2, MatchType.BEST_OF_THREE, true);
       for (int i = 0;i<4*6;i++){
           tennisMatch.playerWinPoint(player1);
       }
       assertEquals("SetWinned",1,tennisMatch.getEndedSet());
    }
}