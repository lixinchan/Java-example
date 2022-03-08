package com.example.design.patterns.pattern.created.prototype;

import com.example.commons.log.LogUtils;

/**
 * prototype pattern
 *
 * @author clx 2018/10/25.
 */
public class TestPrototype {

	public static void main(String[] args) {
		// client to test
		ConcreteType prototype = new ConcreteType();
		for (int idx = 0; idx < 5; idx++) {
			ConcreteType type = (ConcreteType) prototype.clone();
			LogUtils.info("object:{}, ->{}", type.hashCode(), type.showType());
		}
	}
}

