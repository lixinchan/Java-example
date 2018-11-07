package org.design.patterns.pattern.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * @author clx 2018/11/6
 */
public class ObserverPattern {

	public static void main(String[] args) {
		new ObserverPattern().testObserver();
	}

	/**
	 * test observer
	 */
	private void testObserver() {
		ConcreteSubject subject = new ConcreteSubject();
		Observer observer = new ConcreteObserver();
		// register
		subject.addObserver(observer);
		// change state
		subject.change("new State.");
	}
}

/**
 * abstract subject
 */
abstract class AbstractSubject {

	/**
	 * all observer
	 */
	private List<Observer> allObserver = new ArrayList<>();

	/**
	 * add observer
	 * 
	 * @param observer
	 */
	public void addObserver(Observer observer) {
		if (observer == null) {
			return;
		}
		allObserver.add(observer);
		System.out.println("add observer:" + observer.toString());
	}

	/**
	 * delete observer
	 * 
	 * @param observer
	 */
	public void deleteObserver(Observer observer) {
		if (observer == null) {
			return;
		}
		allObserver.remove(observer);
	}

	/**
	 * notify observer
	 * 
	 * @param state
	 */
	public void notify(String state) {
		allObserver.forEach(observer -> observer.update(state));
	}
}

/**
 * concrete subject
 */
class ConcreteSubject extends AbstractSubject {

	/**
	 * state
	 */
	private String state;

	public String getState() {
		return state;
	}

	/**
	 * change state
	 * 
	 * @param state
	 */
	public void change(String state) {
		this.state = state;
		System.out.println("state:" + this.state);

		// state changed notify all observer
		this.notify(state);
	}
}

/**
 * abstract observer
 */
interface Observer {

	/**
	 * update
	 * 
	 * @param state
	 */
	void update(String state);
}

class ConcreteObserver implements Observer {

	/**
	 * observer state
	 */
	private String observerState;

	@Override
	public void update(String state) {
		this.observerState = state;
		System.out.println("state changed:" + this.observerState);
	}
}