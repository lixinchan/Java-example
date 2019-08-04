package com.example.core.java.annotation;

import java.lang.annotation.*;

/**
 * @author clx 3/14/2018
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {

	/**
	 * provider id
	 * 
	 * @return
	 */
	int providerId() default -1;

	/**
	 * provider name
	 * 
	 * @return
	 */
	String providerName() default "";

	/**
	 * provider address
	 * 
	 * @return
	 */
	String providerAddress() default "";
}
