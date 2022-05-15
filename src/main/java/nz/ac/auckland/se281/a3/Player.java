package nz.ac.auckland.se281.a3;

/**
 * This abstract class has all the methods and variables related to the Player
 * object.
 *
 * @author Lia Arroyo
 */
public abstract class Player extends Participant {

	/* INSTANCE VARIABLES */
	protected int numberOfWins;
	protected int numberOfLosses;

	public Player(String name) {
		super(name);
	}

	public int getNumberOfWins() {
		return numberOfWins;
	}

	/**
	 * This method acts like a setter method for the number of wins. It increments
	 * whenever a player has won.
	 */
	public void win() {
		numberOfWins++;
	}

	public int getNumberOfLosses() {
		return numberOfLosses;
	}

	/**
	 * This method acts like a setter method for the number of losses. It increments
	 * whenever a player has lost.
	 */
	public void lose() {
		numberOfLosses++; // acts as a setter method for num losses
	}

	/**
	 * This method calculates then returns the net win, which is the rounds won -
	 * rounds lost.
	 * 
	 * @return the calculated net win
	 */
	public int getNetWin() {
		return numberOfWins - numberOfLosses;
	}

	public abstract int makeABet();

	/**
	 * This helper method checks whether the player won against the dealer.
	 * 
	 * @param dealerHand the hand of the dealer, which contains their score
	 * @return the player's win status. true if player won, and false if player lost
	 */
	public boolean didPlayerWin(Hand dealerHand) {

		// initialising player variables
		int playerScore = this.getHand().getScore();
		int numPlayerCards = this.getHand().getCards().size();
		boolean isPlayerBlackjack = (playerScore == 21 && numPlayerCards == 2); // checking for player blackjack

		// initialising dealer variables
		int dealerScore = dealerHand.getScore();
		int numDealerCards = dealerHand.getCards().size();
		boolean isDealerBlackjack = (dealerScore == 21 && numDealerCards == 2); // checking for dealer blackjack

		/* ----- CHECKING WIN CONDITIONS! ---- */
		if (isPlayerBlackjack && !isDealerBlackjack) {
			// if only the player has blackjack
			return true;

		} else if ((playerScore <= 21) && (playerScore > dealerScore)) {
			// if player score isnt busted and is greater than (note: not equal to) dealer
			return true;

		} else if ((playerScore <= 21) && (dealerScore > 21)) {
			// if player isnt busted but the dealer is
			return true;

		} else {
			// if all the above conditions are not met, then the player has lost
			return false;
		}
	}

}
