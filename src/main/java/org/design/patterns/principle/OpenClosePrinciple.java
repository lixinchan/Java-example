package org.design.patterns.principle;

/**
 * OCP,对扩展开放，对修改关闭
 * 
 * @author clx 2018/7/9.
 */
public class OpenClosePrinciple {

}

/**
 * before refactor
 */
class ChartDisplay {

	/**
	 * display chart
	 * 
	 * @param type
	 */
	void display(String type) {
	}
}

/**
 * before refactor
 */
class PipChart {

	/**
	 * display
	 */
	void display() {

	}
}

/**
 * before refactor
 */
class BarChart {

	/**
	 * display
	 */
	void display() {

	}
}
