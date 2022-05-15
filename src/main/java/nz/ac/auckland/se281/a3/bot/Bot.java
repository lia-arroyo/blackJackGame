package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Player;

/**
 * This class contains all the methods and variables related to the two bots.
 */
public class Bot extends Player {

	/* INSTANCE VARIABLES */
	private BotStrategy strategy;

	/**
	 * This constructor sets the bot's strategy and the bot's name.
	 * 
	 * @param name     the name of the bot
	 * @param strategy the instance of the strategy
	 */
	public Bot(String name, BotStrategy strategy) {
		super(name);
		this.strategy = strategy;
	}

	/**
	 * {@inheritDoc} This method uses the strategy to decide which action to take.
	 * 
	 * @param hand the bot's current hand
	 * @return the action chosen
	 */
	@Override
	public Action decideAction(Hand hand) {
		return strategy.chooseAction(hand);
	}

	/**
	 * {@inheritDoc} This method uses the strategy to decide how much to bet.
	 * 
	 * @return the chosen amount to bet
	 */
	@Override
	public int makeABet() {
		return strategy.chooseBet();
	}

}
