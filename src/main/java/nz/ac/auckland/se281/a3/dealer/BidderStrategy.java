package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Player;

/**
 * This dealer strategy intends to target the player with the highest bet amount
 * 
 * @author Lia Arroyo
 *
 */
public class BidderStrategy implements DealerStrategy {

	/**
	 * {@inheritDoc} This method will choose the player with the highest bet amount
	 * as the dealer's target.
	 * 
	 * @param players a list of all the players
	 * @return the player with the highest bet
	 */
	@Override
	public Player chooseTargetPlayer(List<Player> players) {

		// initialising the target player to be the first player
		Player target = players.get(0);
		int maxBet = target.getHand().getBet();

		// iterating through the players
		for (Player currentPlayer : players) {

			// getting the current player's bet
			int currentBet = currentPlayer.getHand().getBet();

			// checking if current player has a greater bet than the max
			if (currentBet > maxBet) {

				// replace target and max
				target = currentPlayer;
				maxBet = currentBet;
			}
		}

		return target;
	}

}
