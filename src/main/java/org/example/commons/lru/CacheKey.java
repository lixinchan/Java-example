package org.example.commons.lru;

import java.lang.reflect.Array;
import java.util.Collection;

/**
 * @author clx 2019-08-01
 */
public class CacheKey {

	private static Character split = ':';

	private String base;

	public CacheKey(String base) {
		if (base == null || base.trim().length() == 0) {
			throw new IllegalArgumentException("base must be set and not empty.");
		}
		this.base = base;
	}

	/**
	 * gen cache key
	 *
	 * @param prefix
	 * @param objects
	 * @return
	 */
	public String genCacheKey(String prefix, Object... objects) {
		StringBuilder builder = new StringBuilder(256);
		builder.append(base).append(CacheKey.split).append(prefix).append(CacheKey.split);
		for (Object v : objects) {
			if (v != null) {
				if (v.getClass().isArray()) {
					builder.append(this.arrayToString(v)).append(CacheKey.split);
				} else if (v instanceof Collection) {
					builder.append(this.collectionToString((Collection<?>) v)).append(CacheKey.split);
				} else {
					builder.append(String.valueOf(v)).append(CacheKey.split);
				}
			}
		}
		int len = builder.length();
		if (len > 1) {
			builder.setLength(len - 1);
		}
		return builder.toString();
	}

	private String arrayToString(Object v) {
		int len = Array.getLength(v);
		if (len == 0) {
			return "[]";
		} else {
			StringBuilder builder = new StringBuilder(64);
			builder.append('[');
			for (int idx = 0; idx < len; idx++) {
				builder.append(Array.get(v, idx)).append(',');
			}
			if (builder.length() > 1) {
				builder.setLength(builder.length() - 1);
			}
			builder.append(']');
			return builder.toString();
		}
	}

	private String collectionToString(Collection<?> collection) {
		int len = collection.size();
		if (len == 0) {
			return "[]";
		} else {
			StringBuilder builder = new StringBuilder(64);
			builder.append('[');
			for (Object v : collection) {
				builder.append(String.valueOf(v)).append(',');
			}
			if (builder.length() > 1) {
				builder.setLength(builder.length() - 1);
			}
			builder.append(']');
			return builder.toString();
		}
	}
}
