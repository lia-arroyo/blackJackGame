package nz.ac.auckland.se281.a3;

/**
 * 
 * You can (and should) add new fields and/or methods
 *
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

	public void playerWon() {
		numberOfWins++; // acts as a setter method for num wins
	}

	public int getNumberOfLosses() {
		return numberOfLosses;
	}

	public void playerLost() {
		numberOfLosses++; // acts as a setter method for num losses
	}

	public int getNetWin() {
		return numberOfWins - numberOfLosses;
	}

	public abstract int makeABet();

	/**
	 * This method checks whether the player won against the dealer.
	 * 
	 * @param dealerHand the hand of the dealer, which contains their score
	 * @return true if player won, and false if player lost
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
