package com.example.design.patterns.pattern.structural.adapter;

import java.util.Date;

/**
 * @author clx
 */
public class OrderMq {
	/**
	 * user id
	 */
	private String uid;
	/**
	 * sku id
	 */
	private String skuId;
	/**
	 * order id
	 */
	private String orderId;
	/**
	 * order time
	 */
	private Date orderTime;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
}
