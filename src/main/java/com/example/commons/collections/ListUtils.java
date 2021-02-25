package com.example.commons.collections;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author clx
 */
public final class ListUtils {
	private ListUtils() {
	}

	/**
	 * partition list
	 *
	 * @param list          partition list
	 * @param partitionSize size
	 * @param <T>           type
	 * @return list
	 */
	public static <T> List<List<T>> partition(List<T> list, int partitionSize) {
		if (partitionSize <= 0) {
			throw new IllegalArgumentException();
		}
		if (list == null || list.isEmpty()) {
			return new ArrayList<>(0);
		}
		return Lists.partition(list, partitionSize);
	}

	/**
	 * compute average chunk size
	 *
	 * @param total        total
	 * @param maxChunkSize max chunk size
	 * @return average chunk size
	 */
	public static int avgSizePerChunk(int total, int maxChunkSize) {
		if (total < 0 || maxChunkSize < 0) {
			throw new IllegalArgumentException();
		}
		if (total <= maxChunkSize) {
			return maxChunkSize;
		}
		int chunkNum = (total + maxChunkSize - 1) / maxChunkSize;
		return (total + chunkNum - 1) / chunkNum;
	}
}
