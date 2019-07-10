import org.junit.Test;

import static org.junit.Assert.*;

public class TennisMatchTest {
    @Test
    public void Basics() {
        Player player1 = new Player("Roberto");
        Player player2 = new Player("Theo");
        TennisMatch tennisMatch = new TennisMatch(player1,player2, MatchType.BEST_OF_THREE, true);
        assertEquals("getName","Roberto",player1.getName());
        player1.setName("Thomas");
        assertEquals("setName","Thomas",player1.getName());
        assertEquals("getWinnedGameInSet",0,tennisMatch.gamesInSetForPlayer(0,player1));

        assertEquals("getWinnedGameInSet",0,player1.getWinnedGamesInSets(0));
        assertEquals("currentSetNumber",1,tennisMatch.currentSetNumber());

    }

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

        tennisMatch.updateWithPointWonBy(player1);
        assertEquals("Pts","15",tennisMatch.pointsForPlayer(player1));
        tennisMatch.updateWithPointWonBy(player1);
        assertEquals("Pts","30",tennisMatch.pointsForPlayer(player1));
        tennisMatch.updateWithPointWonBy(player1);
        assertEquals("Pts","40",tennisMatch.pointsForPlayer(player1));

        tennisMatch.updateWithPointWonBy(player2);
        assertEquals("Pts","15",tennisMatch.pointsForPlayer(player2));
        tennisMatch.updateWithPointWonBy(player2);
        assertEquals("Pts","30",tennisMatch.pointsForPlayer(player2));
        tennisMatch.updateWithPointWonBy(player2);
        assertEquals("Pts","40",tennisMatch.pointsForPlayer(player2));
    }

    @Test
    public void PlayerAdvantage() {
        Player player1 = new Player("Roberto");
        Player player2 = new Player("Theo");
        TennisMatch tennisMatch = new TennisMatch(player1,player2, MatchType.BEST_OF_THREE, true);
        assertEquals("Pts","0",tennisMatch.pointsForPlayer(player1));
        assertEquals("Pts","0",tennisMatch.pointsForPlayer(player2));

        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);


        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player1);
        assertEquals("Advge","A",tennisMatch.pointsForPlayer(player1));
        assertEquals("Advge","40",tennisMatch.pointsForPlayer(player2));

        tennisMatch.updateWithPointWonBy(player2);
        assertEquals("Advge","40",tennisMatch.pointsForPlayer(player1));
        assertEquals("Advge","A",tennisMatch.pointsForPlayer(player2));

    }

    @Test
    public void PlayerWinByAdvantage() {
        Player player1 = new Player("Roberto");
        Player player2 = new Player("Theo");
        TennisMatch tennisMatch = new TennisMatch(player1,player2, MatchType.BEST_OF_THREE, true);
        assertEquals("Pts","0",tennisMatch.pointsForPlayer(player1));
        assertEquals("Pts","0",tennisMatch.pointsForPlayer(player2));

        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);


        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);
        tennisMatch.updateWithPointWonBy(player2);

        tennisMatch.updateWithPointWonBy(player1);
        assertEquals("Advge","A",tennisMatch.pointsForPlayer(player1));
        assertEquals("Advge","40",tennisMatch.pointsForPlayer(player2));

        tennisMatch.updateWithPointWonBy(player2);
        assertEquals("Advge","40",tennisMatch.pointsForPlayer(player1));
        assertEquals("Advge","A",tennisMatch.pointsForPlayer(player2));

        tennisMatch.updateWithPointWonBy(player2);
        assertEquals("GameWinned",1,tennisMatch.gamesInCurrentSetForPlayer(player2));
    }

    @Test
    public void PlayerGameWin() {
        Player player1 = new Player("Roberto");
        Player player2 = new Player("Theo");
        TennisMatch tennisMatch = new TennisMatch(player1,player2, MatchType.BEST_OF_THREE, true);
        assertEquals("Pts","0",tennisMatch.pointsForPlayer(player1));
        assertEquals("Pts","0",tennisMatch.pointsForPlayer(player2));

        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);
        tennisMatch.updateWithPointWonBy(player1);


        tennisMatch.updateWithPointWonBy(player1);
        assertEquals("GameWinned",1,tennisMatch.gamesInCurrentSetForPlayer(player1));


        tennisMatch.updateWithPointWonBy(player1);
        assertEquals("Pts","15",tennisMatch.pointsForPlayer(player1));
        tennisMatch.updateWithPointWonBy(player1);
        assertEquals("Pts","30",tennisMatch.pointsForPlayer(player1));
        tennisMatch.updateWithPointWonBy(player1);
        assertEquals("Pts","40",tennisMatch.pointsForPlayer(player1));
        tennisMatch.updateWithPointWonBy(player1);
        assertEquals("GameWinned",2,tennisMatch.gamesInCurrentSetForPlayer(player1));

    }

    @Test
    public void PlayerSetWinNoTB() {
        Player player1 = new Player("Roberto");
        Player player2 = new Player("Theo");
        TennisMatch tennisMatch = new TennisMatch(player1,player2, MatchType.BEST_OF_THREE, false);
       for (int i = 0;i<4*6;i++){
           tennisMatch.updateWithPointWonBy(player1);
       }
       assertEquals("SetWinned",1,tennisMatch.getEndedSet());
       assertEquals("currentSetNumber",2,tennisMatch.currentSetNumber());
       assertEquals("getWinnedGameInSet",6,player1.getWinnedGamesInSets(0));
        for (int i = 0;i<4*5;i++){
            tennisMatch.updateWithPointWonBy(player1);
        }
        for (int i = 0;i<4*7;i++){
            tennisMatch.updateWithPointWonBy(player2);
        }
        assertEquals("SetWinned",2,tennisMatch.getEndedSet());

        for (int i = 0;i<4*5;i++){
            tennisMatch.updateWithPointWonBy(player1);
        }
        for (int i = 0;i<4*5;i++){
            tennisMatch.updateWithPointWonBy(player2);
        }
        for (int i = 0;i<4*1;i++){
            tennisMatch.updateWithPointWonBy(player1);
        }
        for (int i = 0;i<4*1;i++){
            tennisMatch.updateWithPointWonBy(player2);
        }
        for (int i = 0;i<4*2;i++){
            tennisMatch.updateWithPointWonBy(player2);
        }
        assertEquals("SetWinned",3,tennisMatch.getEndedSet());

    }

    @Test
    public void PlayerSetWinTB() {
        Player player1 = new Player("Roberto");
        Player player2 = new Player("Theo");
        TennisMatch tennisMatch = new TennisMatch(player1,player2, MatchType.BEST_OF_THREE, true);
        for (int i = 0;i<4*6;i++){
            tennisMatch.updateWithPointWonBy(player1);
        }
        assertEquals("SetWinned",1,tennisMatch.getEndedSet());

        for (int i = 0;i<4*5;i++){
            tennisMatch.updateWithPointWonBy(player1);
        }
        for (int i = 0;i<4*7;i++){
            tennisMatch.updateWithPointWonBy(player2);
        }
        assertEquals("SetWinned",2,tennisMatch.getEndedSet());

    }

    @Test
    public void PlayerSetWinUseTB() {
        Player player1 = new Player("Roberto");
        Player player2 = new Player("Theo");
        TennisMatch tennisMatch = new TennisMatch(player1,player2, MatchType.BEST_OF_THREE, true);

        // 1er set tie break 7 - 0
        for (int i = 0;i<4*5;i++){
            tennisMatch.updateWithPointWonBy(player1);
        }
        for (int i = 0;i<4*6;i++){
            tennisMatch.updateWithPointWonBy(player2);
        }
        assertEquals("SetWinned",0,tennisMatch.getEndedSet());

        for (int i = 0;i<4*1;i++){
            tennisMatch.updateWithPointWonBy(player1);
        }

        assertEquals("SetWinned",0,tennisMatch.getEndedSet());

        for (int i = 0;i<7;i++){
            tennisMatch.updateWithPointWonBy(player1);
        }
        assertEquals("SetWinned",1,tennisMatch.getEndedSet());

        //2 eme set avec tie break 9-7

        for (int i = 0;i<4*5;i++){
            tennisMatch.updateWithPointWonBy(player1);
        }
        for (int i = 0;i<4*6;i++){
            tennisMatch.updateWithPointWonBy(player2);
        }
        assertEquals("SetWinned1",1,tennisMatch.getEndedSet());

        for (int i = 0;i<4*1;i++){
            tennisMatch.updateWithPointWonBy(player1);
        }

        assertEquals("SetWinned2",1,tennisMatch.getEndedSet());

        for (int i = 0;i<6;i++){
            tennisMatch.updateWithPointWonBy(player1);
        }
        for (int i = 0;i<7;i++){
            tennisMatch.updateWithPointWonBy(player2);
        }
        assertEquals("SetWinned3",1,tennisMatch.getEndedSet());
        for (int i = 0;i<3;i++){
            tennisMatch.updateWithPointWonBy(player1);
        }
        assertEquals("SetWinned4",2,tennisMatch.getEndedSet());
    }

    @Test
    public void PlayerWinMatchBOT_TB() { //BOT Best of three | TB tie break in last set
        Player player1 = new Player("Roberto");
        Player player2 = new Player("Theo");
        TennisMatch tennisMatch = new TennisMatch(player1,player2, MatchType.BEST_OF_THREE, true);
        for (int i = 0;i<4*6;i++){
            tennisMatch.updateWithPointWonBy(player1);
        }
        assertEquals("SetWinned",1,tennisMatch.getEndedSet());

        for (int i = 0;i<4*5;i++){
            tennisMatch.updateWithPointWonBy(player1);
        }
        for (int i = 0;i<4*7;i++){
            tennisMatch.updateWithPointWonBy(player2);
        }
        assertEquals("SetWinned",2,tennisMatch.getEndedSet());

        for (int i = 0;i<4*6;i++){
            tennisMatch.updateWithPointWonBy(player1);
        }
        assertEquals("SetWinned",3,tennisMatch.getEndedSet());
        assertEquals("GameWinned",true,tennisMatch.isFinnished());

    }

    @Test
    public void PlayerWinMatchBOF_TB() { //BOT Best of three | TB tie break in last set
        Player player1 = new Player("Roberto");
        Player player2 = new Player("Theo");
        TennisMatch tennisMatch = new TennisMatch(player1,player2, MatchType.BEST_OF_FIVE, true);
        for (int i = 0;i<4*6;i++){
            tennisMatch.updateWithPointWonBy(player1);
        }
        assertEquals("SetWinned",1,tennisMatch.getEndedSet());

        for (int i = 0;i<4*5;i++){
            tennisMatch.updateWithPointWonBy(player1);
        }
        for (int i = 0;i<4*7;i++){
            tennisMatch.updateWithPointWonBy(player2);
        }
        assertEquals("SetWinned",2,tennisMatch.getEndedSet());

        for (int i = 0;i<4*6;i++){
            tennisMatch.updateWithPointWonBy(player1);
        }
        assertEquals("SetWinned",3,tennisMatch.getEndedSet());
        assertEquals("GameWinned",false,tennisMatch.isFinnished());

        for (int i = 0;i<4*6;i++){
            tennisMatch.updateWithPointWonBy(player1);
        }
        assertEquals("SetWinned",4,tennisMatch.getEndedSet());


        for (int i = 0;i<4*6;i++){
            tennisMatch.updateWithPointWonBy(player1);
        }
        assertEquals("SetWinned",5,tennisMatch.getEndedSet());
        assertEquals("GameWinned",true,tennisMatch.isFinnished());
    }
}