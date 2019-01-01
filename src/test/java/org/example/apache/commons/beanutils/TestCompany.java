package org.example.apache.commons.beanutils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.LazyDynaMap;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestCompany {

	public static void main(String[] args)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Company com = new Company();

		com.setName("test");
		System.out.println(com.getName());

		// simple
		BeanUtils.setProperty(com, "name", "Jack");
		BeanUtils.getProperty(com, "name");

		// indexed
		BeanUtils.setProperty(com, "product[1]", "NOTES SERVER");
		BeanUtils.getProperty(com, "product[1]");

		// mapped
		Map<String, String> am = new HashMap<>(10);
		am.put("1", "10010");
		am.put("2", "10010");
		BeanUtils.setProperty(com, "telephone", am);
		BeanUtils.getProperty(com, "telephone(2)");

		// combined
		BeanUtils.getProperty(com, "employee[1].name");

		// copyProperty
		Company com2 = new Company();
		BeanUtils.copyProperties(com2, com);

		// converter
		BeanUtils.setProperty(com, "date", new Date());

		BeanUtils.setProperty(com, "date", "2013-10-01");

		ConvertUtils.register(new Converter() {

			public <T> T convert(Class<T> type, Object value) {
				// TODO Auto-generated method stub
				return null;
			}
		}, Date.class);

		// DynamicBean
		LazyDynaMap dynaBean = new LazyDynaMap();

		dynaBean.set("foo", "bar");
		dynaBean.set("customer", "title", "Rose");
		dynaBean.set("address", 0, "address1");
		System.out.println(dynaBean.get("address", 0));
		Map map = dynaBean.getMap();
		System.out.println(map.toString());

		// returnNull
		dynaBean.setReturnNull(true);

		// Restricted
		dynaBean.setRestricted(true);

	}
}
