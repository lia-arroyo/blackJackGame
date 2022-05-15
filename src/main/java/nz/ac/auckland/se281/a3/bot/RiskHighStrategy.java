package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant;
import nz.ac.auckland.se281.a3.Participant.Action;

/**
 * This strategy allows the bot to be more risky by upping the bet range and
 * being more strategic with the action it chooses.
 * 
 * @author Lia Arroyo
 */
public class RiskHighStrategy implements BotStrategy {

	/**
	 * {@inheritDoc} This method will randomly bet from 50 to 100 (inclusive)
	 * 
	 * @return the randomly generated bet from 50 to 100 (inclusive)
	 */
	@Override
	public int chooseBet() {

		// creating an instance of the JDK Random class.
		Random rand = new Random();

		// creating the randomly generated value from 50 to 100 (inclusive)
		int chosenBet = rand.nextInt(51) + 50; // nextInt generates value between 0-50, so +50 forces to be within range

		// returning the randomly generated value
		return chosenBet;

	}

	/**
	 * {@inheritDoc} This specific method will ensure that the bot HOLDs if the
	 * current score is at least 19, otherwise it HITs.
	 * 
	 * @param hand the bot's current hand
	 * @return the chosen action depending on current score
	 */
	@Override
	public Action chooseAction(Hand hand) {
		// getting the score of current hand
		int currentScore = hand.getScore();

		// choosing action depending on current score
		if (currentScore >= 19) {
			return Participant.Action.HOLD;
		} else {
			return Participant.Action.HIT;
		}
	}

}
