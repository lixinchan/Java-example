package com.example.design.patterns.pattern.behavioral;

/**
 * strategy pattern
 * 
 * @author clx 2018/10/15.
 */
public class StrategyPattern {

	public static void main(String[] args) {
		StrategyContext context = new StrategyContext(new StrategyFirst());
		context.strategyMethod();
		context = new StrategyContext(new StrategySecond());
		context.strategyMethod();
	}
}

/**
 * abstract strategy
 */
interface AbstractStrategy {

	/**
	 * strategy method
	 */
	void useStrategy();
}

/**
 * concrete strategy
 */
class StrategyFirst implements AbstractStrategy {

	@Override
	public void useStrategy() {
		System.out.println("use first strategy.");
	}
}

/**
 * concrete strategy
 */
class StrategySecond implements AbstractStrategy {

	@Override
	public void useStrategy() {
		System.out.println("use second strategy.");
	}
}

/**
 * hold strategy reference
 */
class StrategyContext {

	private AbstractStrategy strategy;

	public StrategyContext(AbstractStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * strategy method
	 */
	public void strategyMethod() {
		strategy.useStrategy();
	}
}