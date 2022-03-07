package com.example.design.patterns.pattern.created.builder;

import java.math.BigDecimal;

/**
 * @author clx
 */
public interface Matter {
	/**
	 * decoration scene
	 *
	 * @return scene
	 */
	String scene();

	/**
	 * decoration brand
	 *
	 * @return brand
	 */
	String brand();

	/**
	 * model
	 *
	 * @return model
	 */
	String model();

	/**
	 * decoration price
	 *
	 * @return price
	 */
	BigDecimal decorationPrice();

	/**
	 * decoration desc
	 *
	 * @return desc
	 */
	String decorationDesc();
}
