package org.example.design.patterns.pattern.structural;

/**
 * adapter pattern
 * 
 * @author clx 2018/10/15.
 */
public class AdapterPattern {

	public static void main(String[] args) {

	}
}

/**
 * target class
 */
interface TargetClass {

	/**
	 * first
	 */
	void getFirst();

	/**
	 * second
	 */
	void getSecond();
}

/**
 * source class
 */
class SourceClass {

	/**
	 * first
	 */
	public void getFirst() {

	}

}

/**
 * class adapter
 */
class ClassAdapter extends SourceClass implements TargetClass {

	@Override
	public void getSecond() {
		System.out.println("adapter second.");
	}
}

/**
 * object source class
 */
class ObjectSource {

	/**
	 * first
	 */
	public void getFirst() {

	}
}

/**
 * object adapter
 */
class ObjectAdapter {

	/**
	 * source
	 */
	private ObjectSource source;

	public ObjectAdapter(ObjectSource source) {
		this.source = source;
	}

	/**
	 * first
	 */
	public void getFirst() {
		this.source.getFirst();
	}

	/**
	 * second
	 */
	public void getSecond() {

	}
}
