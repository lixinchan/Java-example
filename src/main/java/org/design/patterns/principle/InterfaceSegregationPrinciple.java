package org.design.patterns.principle;

/**
 * ISP,使用多个专门的接口，而不使用单一的总接口，即客户端不应该依赖那些它不需要的接口
 * 
 * @author clx 2018/7/23
 */
public class InterfaceSegregationPrinciple {

	interface DataHelper {
		/**
		 * data read
		 */
		void dataRead();
	}

	interface ChartHelper {
		/**
		 * display chart
		 */
		void displayChart();
	}

	interface ReportHelper {
		/**
		 * display report
		 */
		void dispalyReport();
	}
}

/**
 * before refactor
 */
interface ConsumerDataDisplay {

	/**
	 * data read
	 */
	void dataRead();

	/**
	 * display chart
	 */
	void displayChart();

	/**
	 * display report
	 */
	void dispalyReport();
}
