package org.design.patterns.pattern.structural;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.commons.lang3.StringUtils;

/**
 * @author clx 2018/11/2
 */
public class ProxyPattern {

	public static void main(String[] args) {
		// static proxy test
		StaticAbstractObject abstractObject = new StaticProxyObject();
		System.out.println(new StaticProxy(abstractObject).getTitle("google.com"));

		// dynamic proxy test
		new ProxyPattern().testDynamicProxy();
	}

	public void testDynamicProxy() {
		InvocationHandler handler = new DynamicProxy(new StaticProxyObject());
		StaticAbstractObject proxy = (StaticAbstractObject) Proxy.newProxyInstance(this.getClass().getClassLoader(),
				new Class[] { StaticAbstractObject.class }, handler);
		System.out.println(proxy.getTitle("google.com"));
	}
}

/**
 * 抽象代理角色
 */
interface StaticAbstractObject {

	/**
	 * get title
	 * 
	 * @param url
	 * @return
	 */
	String getTitle(String url);
}

/**
 * 目标代理角色
 */
class StaticProxyObject implements StaticAbstractObject {

	@Override
	public String getTitle(String url) {
		if (StringUtils.equals(url, "google.com")) {
			return "google";
		}
		return null;
	}
}

class StaticProxy implements StaticAbstractObject {

	private StaticAbstractObject abstractObject;

	public StaticProxy(StaticAbstractObject abstractObject) {
		this.abstractObject = abstractObject;
	}

	@Override
	public String getTitle(String url) {
		return abstractObject.getTitle(url);
	}
}

class DynamicProxy implements InvocationHandler {

	private Object object;

	public DynamicProxy(Object object) {
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		StringBuilder builder = new StringBuilder(32);
		builder.append(method.invoke(object, args));
		return builder.toString();
	}
}