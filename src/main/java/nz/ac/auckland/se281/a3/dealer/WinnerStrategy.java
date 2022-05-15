package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Player;

/**
 * This dealer strategy intends to target the player with the highest number of
 * net wins (rounds won - rounds lost)
 * 
 * @author Lia Arroyo
 *
 */
public class WinnerStrategy implements DealerStrategy {

	/**
	 * {@inheritDoc} This specific method will choose the player with the highest
	 * net wins.
	 * 
	 * @param players the list of all the players
	 * @return the player with the highest net win
	 */
	@Override
	public Player chooseTargetPlayer(List<Player> players) {
		// initialising the target player to be the first player
		Player target = players.get(0);
		int maxNetWin = target.getNetWin();

		// iterating through the players
		for (Player currentPlayer : players) {

			// getting the current player's net win
			int currentNetWin = currentPlayer.getNetWin();

			// checking if current player has a greater net win than the max
			if (currentNetWin > maxNetWin) {
				// replace target and max
				target = currentPlayer;
				maxNetWin = currentNetWin;
			}
		}

		return target;
	}

}
