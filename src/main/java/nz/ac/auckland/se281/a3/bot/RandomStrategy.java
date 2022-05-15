package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Participant;
import nz.ac.auckland.se281.a3.Participant.Action;

/**
 * This strategy allows for the bot to randomly choose between HOLD and HIT, and
 * randomly bet between 1 and 100 chips.
 * 
 * @author Lia Arroyo
 */
public class RandomStrategy implements BotStrategy {

	/**
	 * {@inheritDoc} This method will specifically choose a bet between 1 and 100
	 * chips (inclusive) randomly.
	 * 
	 * @return the random generated bet
	 */
	@Override
	public int chooseBet() {

		// initialising the bets to 1
		int chosenBet = 1;

		// creating an instance of the JDK Random class.
		Random rand = new Random();

		// creating the randomly generated value from 1 to 100 chips (inclusive)
		chosenBet = rand.nextInt(100) + 1; // nextInt generates a value between 0-99, so +1 forces it to be within range

		// returning the randomly generated value
		return chosenBet;

	}

	/**
	 * {@inheritDoc} This specific method randomly chooses between HOLD and HIT
	 * action.
	 * 
	 * @return the randomly generated action
	 */
	@Override
	public Action chooseAction() {
		// creating an instance of the JDK Random class.
		Random rand = new Random();

		// creates a randomly generated value between 0 and 1
		int randomValue = rand.nextInt(2);

		// interpreting the randomly generated value, with a 50% chance of each.
		if (randomValue == 1) {
			return Participant.Action.HIT;
		} else {
			return Participant.Action.HOLD;
		}
	}

}
