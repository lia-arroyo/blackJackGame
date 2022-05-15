package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Player;

/**
 * you should change this class for TASK 1
 */
public class Bot extends Player {

	/* INSTANCE VARIABLES */
	BotStrategy strategy;

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
	 * {@inheritDoc}
	 */
	@Override
	public Action decideAction(Hand hand) {
		return strategy.chooseAction(hand);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int makeABet() {
		return strategy.chooseBet();
	}

}
