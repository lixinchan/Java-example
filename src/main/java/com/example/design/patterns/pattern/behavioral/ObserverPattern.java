package com.example.design.patterns.pattern.behavioral;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.apache.commons.lang3.StringUtils;

/**
 * @author clx 2018/11/6
 */
public class ObserverPattern {

	public static void main(String[] args) {
		new ObserverPattern().testObserver();
		new ObserverPattern().testJDKObserver();
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

	/**
	 * test Observable
	 */
	private void testJDKObserver() {
		OwnSubject subject = new OwnSubject();
		java.util.Observer observer = new OwnObserver();
		subject.addObserver(observer);
		subject.setData("start");
		subject.setData("running");
		subject.setData("stop");
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

/**
 * concrete subject
 */
class OwnSubject extends Observable {

	private String data = "";

	public String getData() {
		return data;
	}

	public void setData(String data) {
		if (StringUtils.isNotBlank(data)) {
			this.data = data;
			super.setChanged();
		}
		super.notifyObservers();
	}
}

/**
 * concrete observer
 */
class OwnObserver implements java.util.Observer {

	private String data;

	public String getData() {
		return data;
	}

	@Override
	public void update(Observable o, Object arg) {
		this.data = ((OwnSubject) o).getData();
		System.out.println("state changed:" + this.data);
	}
}