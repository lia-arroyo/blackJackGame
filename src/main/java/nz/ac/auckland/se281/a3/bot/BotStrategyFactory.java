package nz.ac.auckland.se281.a3.bot;

public class BotStrategyFactory {

	/**
	 * This method will create an instance of the bot's chosen strategy and return
	 * it.
	 * 
	 * @param chosenStrategy string which user inputted that determines the strategy
	 * @param hand the bot's current hand
	 * @return an instance of the chosen strategy
	 */
	public static BotStrategy chooseBotStrategy(String chosenStrategy) {

		switch (chosenStrategy) {
		case "R":
			return new RandomStrategy();
		case "LR":
			return new RiskLowStrategy();
		case "HR":
			return new RiskHighStrategy();
		default:
			return null;
		}

	}

}
