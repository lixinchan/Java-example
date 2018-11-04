package org.design.patterns.pattern.structural;

/**
 * @author clx 2018/11/2
 */
public class ProxyPattern {

	public static void main(String[] args) {

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
		return null;
	}
}