package com.example.design.patterns.pattern.created.prototype;

import com.example.commons.log.LogUtils;
import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * @author clx
 */
public abstract class AbstractPrototype implements Cloneable {

	private AbstractPrototype prototype = null;
	private ArrayList<String> topicList = Lists.newArrayList();

	@Override
	public AbstractPrototype clone() {
		try {
			prototype = (AbstractPrototype) super.clone();
			prototype.topicList = (ArrayList<String>) topicList.clone();
		} catch (CloneNotSupportedException ex) {
			LogUtils.error("Prototype: err={}", ex.toString());
		}
		return prototype;
	}

	/**
	 * show type
	 *
	 * @return String
	 */
	public abstract String showType();
}
