package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant;
import nz.ac.auckland.se281.a3.Participant.Action;

/**
 * This strategy allows the bot to be less risky when deciding the action, and
 * bets smaller amounts.
 * 
 * @author Lia Arroyo
 */
public class RiskLowStrategy implements BotStrategy {

	/**
	 * {@inheritDoc} This method will randomly bet from 10 to 50 chips (inclusive)
	 * 
	 * @return the randomly generated bet from 10 to 50 chips (inclusive)
	 */
	@Override
	public int chooseBet() {
		// creating an instance of the JDK Random class.
		Random rand = new Random();

		// creating the randomly generated value from 10 to 50 (inclusive)
		int chosenBet = rand.nextInt(41) + 10; // nextInt generates value between 0-40, so +10 forces it to be within range

		// returning the randomly generated value
		return chosenBet;

	}

	/**
	 * {@inheritDoc} This specific method will ensure that the bot HOLDs if the
	 * current score is at least 17, otherwise it HITs.
	 * 
	 * @param hand the bot's current hand
	 * @return the chosen action depending on current score
	 */
	@Override
	public Action chooseAction(Hand hand) {
		// getting the score of current hand
		int currentScore = hand.getScore();

		// choosing action depending on current score
		if (currentScore >= 17) {
			return Participant.Action.HOLD;
		} else {
			return Participant.Action.HIT;
		}
	}

}
