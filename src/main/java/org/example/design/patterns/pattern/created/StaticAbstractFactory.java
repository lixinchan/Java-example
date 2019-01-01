package org.example.design.patterns.pattern.created;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author clx 2018/10/15.
 */
public class StaticAbstractFactory {

	public static void main(String[] args) {
		Staff staff = StaffFactory.getStaff("xxx");
		if (staff != null) {
			System.out.println(staff.getStaffName(1));
			System.out.println(staff.getStaffPhone(1));
		}
	}
}

/**
 * staff factory
 */
class StaffFactory {
	private final static Logger logger = LoggerFactory.getLogger(StaffFactory.class);

	public static Staff getStaff(String staffClasspath) {
		if (staffClasspath == null || staffClasspath.length() == 0) {
			logger.error("config is empty!");
			return null;
		}

		try {
			Class<?> staff = Class.forName(staffClasspath);
			return (Staff) staff.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
			logger.error("no class found by classpath={}", staffClasspath);
		}
		return null;
	}
}

/**
 * interface
 */
interface Staff {

	/**
	 * get staff name
	 * 
	 * @param id
	 * @return
	 */
	String getStaffName(Integer id);

	/**
	 * get staff mobile phone
	 * 
	 * @param id
	 * @return
	 */
	String getStaffPhone(Integer id);
}

/**
 * basic staff
 */
class BasicStaff implements Staff {

	@Override
	public String getStaffName(Integer id) {
		return null;
	}

	@Override
	public String getStaffPhone(Integer id) {
		return null;
	}
}

/**
 * manager
 */
class Manager implements Staff {

	@Override
	public String getStaffName(Integer id) {
		return null;
	}

	@Override
	public String getStaffPhone(Integer id) {
		return null;
	}
}
