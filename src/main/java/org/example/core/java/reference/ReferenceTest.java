package org.example.core.java.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author clx 2017年9月24日 下午4:00:56
 */
public class ReferenceTest {

	public static void main(String[] args) {
		// strongReference();
		// softReference();
		// weakReference();
		// phantomReference();
		weakHashMap();
	}

	/**
	 * Strong reference
	 */
	public static void strongReference() {
		People people = new People("clx", 26);
		System.out.println(people);
		people = null;
		System.out.println(people);
	}

	/**
	 * Soft reference
	 */
	public static void softReference() {
		People people = new People("clx", 26);
		System.out.println(people);
		ReferenceQueue<People> rq = new ReferenceQueue<People>();
		SoftReference<People> sr = new SoftReference<People>(people, rq);
		people = null;
		System.gc();
		System.out.println(sr.get());
		System.out.println(rq.poll());
	}

	/**
	 * Weak reference
	 */
	public static void weakReference() {
		People people = new People("clx", 26);
		System.out.println(people);
		ReferenceQueue<People> rq = new ReferenceQueue<People>();
		WeakReference<People> wr = new WeakReference<People>(people, rq);
		people = null;
		System.gc();
		System.gc();
		System.out.println(wr.get());
		System.out.println(rq.poll());
	}

	/**
	 * Phantom reference
	 */
	public static void phantomReference() {
		People people = new People("clx", 26);
		System.out.println(people);
		ReferenceQueue<People> rq = new ReferenceQueue<People>();
		PhantomReference<People> pr = new PhantomReference<People>(people, rq);
		people = null;

		System.out.println(pr.get());
		System.out.println(rq.poll());
	}

	/**
	 * WeakHashMap test
	 */
	public static void weakHashMap() {
		Map<String, People> map = new WeakHashMap<String, People>();
		String key = new String("one");
		People people = new People("clx", 26);
		map.put(key, people);

		System.out.println(map);
		key = null;
		System.gc();
		System.out.println(map.get(key));
		System.out.println(map.containsKey(key));
		System.out.println(map);
	}
}

class People {
	private String name;
	private int age;

	public People(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + "]";
	}
}
