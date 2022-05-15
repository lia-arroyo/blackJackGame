package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant;

/**
 * This interface contains all the required methods for each bot strategy.
 * 
 * @author Lia Arroyo
 *
 */
public interface BotStrategy {

	/**
	 * This method will decide how many chips the bot will bet depending on the
	 * strategy.
	 * 
	 * @return the number of chips the bot will bet
	 */
	public int chooseBet();

	/**
	 * This method will decide which action the bot will do (either HIT or HOLD)
	 * depending on the strategy.
	 *
	 * @param hand the current hand of the bot
	 * @return the action the bot will do
	 */
	public Participant.Action chooseAction(Hand hand);
}
