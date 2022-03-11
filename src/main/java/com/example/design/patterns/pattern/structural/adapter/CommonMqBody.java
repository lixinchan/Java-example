package com.example.design.patterns.pattern.structural.adapter;

/**
 * @author clx
 */
public class CommonMqBody {
	/**
	 * user id
	 */
	private String userId;
	/**
	 * biz id
	 */
	private String bizId;
	/**
	 * biz time
	 */
	private String bizTime;
	/**
	 * biz desc
	 */
	private String bizDesc;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String getBizTime() {
		return bizTime;
	}

	public void setBizTime(String bizTime) {
		this.bizTime = bizTime;
	}

	public String getBizDesc() {
		return bizDesc;
	}

	public void setBizDesc(String bizDesc) {
		this.bizDesc = bizDesc;
	}
}
