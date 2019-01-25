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
        tennisMatch.playerWinPoint(player1);
        tennisMatch.playerWinPoint(player1);
        assertEquals("Loul","30",tennisMatch.pointsForPlayer(player1));
    }
}