package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant;
import nz.ac.auckland.se281.a3.Player;

/**
 * This class contains all methods and variables related to the dealer of the
 * game.
 *
 * @author Lia Arroyo
 */
public class Dealer extends Participant {

	/* INSTANCE VARIABLES */
	private DealerStrategy strategy;
	private List<Player> players;

	/**
	 * This constructor takes in the initial strategy, name, and a list of all
	 * players.
	 * 
	 * @param name     name of the dealer
	 * @param strategy the initial strategy
	 * @param players  a list of all the players
	 */
	public Dealer(String name, DealerStrategy strategy, List<Player> players) {
		super(name);
		this.strategy = strategy;
		this.players = players;
	}

	public void setStrategy(DealerStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * This method determines the best possible action a dealer can have based on
	 * their target player's hand.
	 * 
	 * @param player the target player
	 * @param hand   the dealer's hand
	 * @return the best action a dealer can do for current round
	 */
	public Action defeatPlayer(Player player, Hand hand) {
		// player variables
		int playerScore = player.getHand().getScore();
		boolean isPlayerBlackjack = ((playerScore == 21) && (player.getHand().getCards().size() == 2));

		// dealer variables
		int dealerScore = hand.getScore();
		// no need to check if dealer is blackjack cos code won't call unless it isn't

		/* DETERMINING BEST ACTION */
		if (playerScore > 21) {
			// if player is busted
			return Action.HOLD;

		} else if (!isPlayerBlackjack && (dealerScore >= playerScore)) {
			// if player is not blackjack, <= 21, and if dealer already has a higher score
			return Action.HOLD;

		} else if (isPlayerBlackjack && (dealerScore >= 17)) {
			// if player has blackjack, we can't win anyway so best action is to hold unless
			// our score is still low
			return Action.HOLD;

		} else {
			// if the above conditions fail then just hit
			return Action.HIT;
		}

	}

	/**
	 * {@inheritDoc} This document decides which action to take depending on the
	 * target player given by the strategy.
	 * 
	 * @param hand the dealer's current hand
	 * @return the dealer's action
	 */
	@Override
	public Action decideAction(Hand hand) {

		// getting the target player
		Player target = strategy.chooseTargetPlayer(players);

		// determining best action to defeat player
		Action bestAction = defeatPlayer(target, hand);

		return bestAction;
	}

}
