package org.design.patterns.pattern.structural;

import org.apache.commons.lang3.StringUtils;

/**
 * @author clx 2018/11/2
 */
public class ProxyPattern {

	public static void main(String[] args) {
		StaticAbstractObject abstractObject = new StaticProxyObject();
		System.out.println(new StaticProxy(abstractObject).getTitle("google.com"));
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