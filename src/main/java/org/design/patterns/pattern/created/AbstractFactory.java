package org.design.patterns.pattern.created;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author clx 2018/7/8
 */
public class AbstractFactory {

	public static void main(String[] args) {
		AbstractPizzaStore bjPizzaStore = new BjPizzaStore();
		AbstractPizza duckPizza = bjPizzaStore.orderPizza("Duck");
		System.out.println("Tom order a " + duckPizza.getName());

		AbstractPizzaStore csPizzaStore = new ChangShaPizzaStore();
		AbstractPizza tofuPizza = csPizzaStore.orderPizza("Tofu");
		System.out.println("Jerry order a " + tofuPizza.getName());
	}
}

/**
 * abstract pizza store factory
 */
abstract class AbstractPizzaStore {

	/**
	 * abstract factory method
	 * 
	 * @param pizzaType
	 * @return
	 */
	protected abstract AbstractPizza createPizza(String pizzaType);

	/**
	 * order pizza
	 * 
	 * @param pizzaType
	 * @return
	 */
	public AbstractPizza orderPizza(String pizzaType) {
		AbstractPizza pizza = this.createPizza(pizzaType);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}

/**
 * product pizza store
 */
class BjPizzaStore extends AbstractPizzaStore {

	private static final Logger logger = LoggerFactory.getLogger(BjPizzaStore.class);

	@Override
	protected AbstractPizza createPizza(String pizzaType) {
		if (StringUtils.isBlank(pizzaType)) {
			logger.error("BjPizzaStore:no pizzaType={} found.", pizzaType);
			return null;
		}
		switch (pizzaType) {
		case "Duck":
			return new BjSauceDuckStylePizza();
		default:
			logger.error("BjPizzaStore:no pizzaType={} found.", pizzaType);
			return null;
		}
	}
}

/**
 * product pizza store
 */
class ChangShaPizzaStore extends AbstractPizzaStore {

	private static final Logger logger = LoggerFactory.getLogger(ChangShaPizzaStore.class);

	@Override
	protected AbstractPizza createPizza(String pizzaType) {
		if (StringUtils.isBlank(pizzaType)) {
			logger.error("ChangShaPizzaStore:no pizzaType={} found.", pizzaType);
			return null;
		}
		switch (pizzaType) {
		case "Duck":
			return new ChangShaSauceDuckStylePizza();
		case "Tofu":
			return new ChangShaTofuStylePizza();
		default:
			logger.error("ChangShaPizzaStore:no pizzaType={} found.", pizzaType);
			return null;
		}
	}
}

/**
 * abstract product
 */
abstract class AbstractPizza {

	/**
	 * pizza name
	 */
	protected String name;

	/**
	 * pizza dough
	 */
	protected String dough;

	/**
	 * pizza sauce
	 */
	protected String sauce;

	/**
	 * pizza toppings
	 */
	protected List<String> toppings = new ArrayList<>();

	/**
	 * prepare pizza
	 */
	public void prepare() {
		System.out.println("preparing pizza: " + this.name);
		System.out.println("tossing dough: " + this.dough);
		System.out.println("adding sauce: " + this.sauce);
		System.out.print("adding toppings: ");
		toppings.forEach(System.out::println);
	}

	/**
	 * bake pizza
	 */
	public void bake() {
		System.out.println("bake pizza...");
	}

	/**
	 * cut pizza
	 */
	public void cut() {
		System.out.println("cut pizza...");
	}

	/**
	 * box pizza
	 */
	public void box() {
		System.out.println("box pizza...");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDough() {
		return dough;
	}

	public void setDough(String dough) {
		this.dough = dough;
	}

	public String getSauce() {
		return sauce;
	}

	public void setSauce(String sauce) {
		this.sauce = sauce;
	}

	public List<String> getToppings() {
		return toppings;
	}

	public void setToppings(List<String> toppings) {
		this.toppings = toppings;
	}

	@Override
	public String toString() {
		return "AbstractPizza{" + "name='" + name + '\'' + ", dough='" + dough + '\'' + ", sauce='" + sauce + '\''
				+ ", toppings=" + toppings + '}';
	}
}

/**
 * product
 */
class BjSauceDuckStylePizza extends AbstractPizza {
	public BjSauceDuckStylePizza() {
		super.name = "Duck Pizza";
		super.dough = "Thin Crust Dough";
		super.sauce = "Sauce Oil";
		super.toppings.add("Cheese");
	}

	@Override
	public void bake() {
		System.out.println("bake for 25 minutes...");
	}

	@Override
	public void box() {
		System.out.println("box with two knife and fork...");
	}
}

/**
 * product
 */
class ChangShaSauceDuckStylePizza extends AbstractPizza {
	public ChangShaSauceDuckStylePizza() {
		super.name = "Duck Pizza";
		super.dough = "Thin Crust Dough";
		super.sauce = "Sauce Oil";
		super.toppings.add("Cheese");
	}

	@Override
	public void bake() {
		System.out.println("bake for 25 minutes...");
	}

	@Override
	public void box() {
		System.out.println("box with two knife and fork...");
	}
}

/**
 * product
 */
class ChangShaTofuStylePizza extends AbstractPizza {
	public ChangShaTofuStylePizza() {
		super.name = "Tofu Pizza";
		super.dough = "Thin Crust Dough";
		super.sauce = "Chili Sauce";
		super.toppings.add("oil");
	}

	@Override
	public void cut() {
		System.out.println("cut pizza to four pieces...");
	}

	@Override
	public void box() {
		System.out.println("box with two knife and fork...");
	}
}