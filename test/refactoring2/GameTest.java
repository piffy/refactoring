/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package refactoring2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/*
Original code by Victor Farcic, https://github.com/vfarcic

**Rules:**

* Scores from zero to three points are described as "love", "fifteen", "thirty", and "forty" respectively.
* If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is "advantage" for the player in the lead.
* If at least three points have been scored by each player, and the scores are equal, the score is "deuce".
* A game is won by the first player to have won at least four points in total and at least two points more than the opponent.
*/
public class GameTest {

    Player victor;
    Player sarah;
    Game game;

    @Before
    public void beforeGameTest() {
        victor = new Player("Victor");
        sarah = new Player("Sarah");
        game = new Game(victor, sarah);
    }

    @Test
    public void loveShouldBeDescriptionForScore0() {
        Game game = new Game(victor, sarah);
        assertEquals(game.getScore(), "love, love");
    }

    @Test
    public void fifteenShouldBeDescriptionForScore1() {
        sarah.winBall();
        assertEquals(game.getScore(), "love, fifteen");
    }

    @Test
    public void thirtyShouldBeDescriptionForScore2() {
        victor.winBall();
        victor.winBall();
        sarah.winBall();
        assertEquals(game.getScore(), "thirty, fifteen");
    }

    @Test
    public void fortyShouldBeDescriptionForScore3() {
        victor.winBall();victor.winBall();victor.winBall();
        assertEquals(game.getScore(), "forty, love");
    }

    @Test
    public void advantageShouldBeDescriptionWhenLeastThreePointsHaveNeenScoredByEachSideAndPlayerHasOnePointMoreThanHisOpponent() {
        victor.winBall();victor.winBall();victor.winBall();
        sarah.winBall();sarah.winBall();sarah.winBall();sarah.winBall();
        assertEquals(game.getScore(), "advantage Sarah");
    }

    @Test
    public void deuceShouldBeDescriptionWhenAtLeastThreePointsHaveBeenScoredByEachPlayerAndTheScoresAreEqual() {
        victor.winBall();victor.winBall();victor.winBall();
        sarah.winBall();sarah.winBall();sarah.winBall();
        assertEquals(game.getScore(), "deuce");
        victor.winBall();
        assertFalse(game.getScore().equals("deuce"));
        sarah.winBall();
        assertEquals(game.getScore(), "deuce");
    }

    @Test
    public void gameShouldBeWonByTheFirstPlayerToHaveWonAtLeastFourPointsInTotalAndWithAtLeastTwoPointsMoreThanTheOpponent() {
        victor.winBall();victor.winBall();victor.winBall();victor.winBall();
        sarah.winBall();sarah.winBall();sarah.winBall();
        assertFalse(game.getScore().equals("Victor won"));
        assertFalse(game.getScore().equals("Sarah won"));
        victor.winBall();
        assertEquals(game.getScore(), "Victor won");
    }

}