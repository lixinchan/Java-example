package org.design.patterns.pattern.created;

/**
 * prototype pattern
 * 
 * @author clx 2018/10/25.
 */
public class Prototype {

	public static void main(String[] args) {
		// client to test
		ConcreteType prototype = new ConcreteType();
		for (int idx = 0; idx < 5; idx++) {
			ConcreteType type = (ConcreteType) prototype.clone();
			System.out.print("object:" + type.hashCode() + "->");
			type.showType();
		}

	}
}

/**
 * abstract prototype
 */
abstract class AbstractPrototype implements Cloneable {

	private AbstractPrototype prototype = null;

	@Override
	public AbstractPrototype clone() {
		try {
			prototype = (AbstractPrototype) super.clone();
		} catch (CloneNotSupportedException ex) {
			System.out.println(ex.getMessage());
		}
		return prototype;
	}

	/**
	 * show type
	 */
	public abstract void showType();
}

/**
 * concrete type
 */
class ConcreteType extends AbstractPrototype {

	@Override
	public void showType() {
		System.out.println("show type");
	}
}
