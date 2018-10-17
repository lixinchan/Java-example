package org.design.patterns.pattern.created;

import java.util.ArrayList;
import java.util.List;

/**
 * @author clx 2018/7/8
 */
public class AbstractFactory {

	public static void main(String[] args) {

	}
}

/**
 * abstract factory
 */
abstract class AbstractPizzaStore {

	/**
	 * create pizza
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
 * abstract product
 */
abstract class AbstractPizza {

	/**
	 * pizza name
	 */
	private String name;

	/**
	 * pizza dough
	 */
	private String dough;

	/**
	 * pizza sauce
	 */
	private String sauce;

	/**
	 * pizza toppings
	 */
	private List<String> toppings = new ArrayList<>();

	/**
	 * prepare pizza
	 */
	public void prepare() {
		System.out.println("preparing " + name);
		System.out.println("tossing dough...");
		System.out.println("adding sauce...");
		System.out.println("adding toppings:");
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