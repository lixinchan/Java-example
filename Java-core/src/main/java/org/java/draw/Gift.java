package org.java.draw;

/**
 * @author chenlixin at 2015年9月14日 下午3:38:01
 */
public class Gift {
	/**
	 * id
	 */
	private int index;
	/**
	 * gift id
	 */
	private String giftId;
	/**
	 * gift name
	 */
	private String giftName;
	/**
	 * 中奖几率
	 */
	private double probability;

	public Gift(int index, String giftId, String giftName, double probability) {
		this.index = index;
		this.giftId = giftId;
		this.giftName = giftName;
		this.probability = probability;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getGiftId() {
		return giftId;
	}

	public void setGiftId(String giftId) {
		this.giftId = giftId;
	}

	public String getGiftName() {
		return giftName;
	}

	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

	@Override
	public String toString() {
		return "Gift [index=" + index + ", giftId=" + giftId + ", giftName="
				+ giftName + ", probability=" + probability + "]";
	}
}
