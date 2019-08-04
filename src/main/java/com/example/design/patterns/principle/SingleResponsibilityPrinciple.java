package com.example.design.patterns.principle;

import java.sql.Connection;
import java.util.List;

/**
 * SRP,一个类只负责相应功能领域的职责
 * 
 * @author clx 2018/7/8
 */
public class SingleResponsibilityPrinciple {

}

/**
 * after refactor
 */
interface consumerDataChart {

	/**
	 * create customer chart
	 */
	void createChart();

	/**
	 * display customer chart
	 */
	void showChart();
}

/**
 * after refactor
 */
interface CustomerDao {
	/**
	 * get customers
	 *
	 * @return
	 */
	List getCustomers();
}

/**
 * after refactor
 */
class DbUtils {

	/**
	 * get db connection
	 * 
	 * @return
	 */
	Connection getConnection() {
		return null;
	}
}

/**
 * before refactor, the response of class CustomerDataChart
 */
interface CustomerDataChart {

	/**
	 * get db connection
	 * 
	 * @return
	 */
	Connection getConnection();

	/**
	 * get customers
	 * 
	 * @return
	 */
	List getCustomers();

	/**
	 * create customer chart
	 */
	void createChart();

	/**
	 * display customer chart
	 */
	void showChart();
}