package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Player;

/**
 * This interface contains all the required methods for each dealer strategy.
 * 
 * @author Lia Arroyo
 */
public interface DealerStrategy {

	/**
	 * This method will choose a player which the dealer will target in one round
	 * depending on the given strategy
	 * 
	 * @param players a list of all players (which contain info about each player)
	 * @return the target player
	 */
	public Player chooseTargetPlayer(List<Player> players);
}
