package org.example.core.java.draw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chenlixin at 2015年9月14日 下午3:38:33
 */
public class LotteryUtil {
	public static int lottery(List<Double> orignalRates) {
		if (orignalRates == null || orignalRates.isEmpty()) {
			return -1;
		}
		// 计算总概率，这样可以保证不一定总概率是1
		int size = orignalRates.size();
		double sumRate = 0;
		for (double rate : orignalRates) {
			sumRate += rate;
		}
		// 计算每个物品在总概率的基础下的概率情况
		List<Double> sortOrignalRates = new ArrayList<Double>(size);
		double tempSumRate = 0;
		for (double rate : orignalRates) {
			tempSumRate += rate;
			sortOrignalRates.add(tempSumRate / sumRate);
		}
		// 根据区块值来获取抽取到的物品索引
		double nextDouble = Math.random();
		sortOrignalRates.add(nextDouble);
		Collections.sort(sortOrignalRates);
		return sortOrignalRates.indexOf(nextDouble);
	}
}
