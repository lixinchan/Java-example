package org.example.design.patterns.principle;

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
// class ChartDisplay {
//
// /**
// * display chart
// *
// * @param type
// */
// void display(String type) {
// if (type.equals("")) {
// PipChart pipChart = new PipChart();
// pipChart.display();
// }
// if (type.equals("")) {
// BarChart barChart = new BarChart();
// barChart.display();
// }
// }
// }

/**
 * before refactor
 */
// class PipChart {
//
// /**
// * display
// */
// void display() {
//
// }
// }

/**
 * before refactor
 */
// class BarChart {
//
// /**
// * display
// */
// void display() {
//
// }
// }

/**
 * after refactor
 */
class ChartDisplay {

	/**
	 * abstract ChartDisplay
	 */
	private AbstractChartDisplay chartDisplay;

	/**
	 * set chart display
	 * 
	 * @param chartDisplay
	 */
	public void setChartDisplay(AbstractChartDisplay chartDisplay) {
		this.chartDisplay = chartDisplay;
	}

	/**
	 * display
	 */
	public void display() {
		chartDisplay.display();
	}

}

/**
 * after refactor
 */
abstract class AbstractChartDisplay {
	/**
	 * abstract display
	 */
	protected abstract void display();
}

/**
 * after refactor
 */
class PipChart extends AbstractChartDisplay {
	@Override
	protected void display() {

	}
}

/**
 * after refactor
 */
class BarChart extends AbstractChartDisplay {
	@Override
	protected void display() {

	}
}
