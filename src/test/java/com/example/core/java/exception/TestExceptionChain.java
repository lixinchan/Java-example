package com.example.core.java.exception;

import org.junit.Test;

/**
 * @author clx
 */
public class TestExceptionChain {

	@Test
	public void testOne() throws Throwable {
		ExceptionChain.testOne();
	}

	@Test
	public void testTwo() {
		ExceptionChain.testTwo();
	}

	@Test
	public void testThree() {
		System.out.println(ExceptionChain.testThree(3));
	}

	@Test
	public void testFour() {
		ExceptionChain.testFour();
	}
}
