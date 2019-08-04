package com.example.commons.web;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author clx 2019-08-01
 */
public final class ParamUtils {
	private ParamUtils() {
	}

	/**
	 * get string param
	 *
	 * @param params
	 * @param key
	 * @return
	 */
	public static String getStr(Map<String, Object> params, String key) {
		return getStr(params, key, null);
	}

	/**
	 * get string param with default value
	 *
	 * @param params
	 * @param key
	 * @param defVal
	 * @return
	 */
	public static String getStr(Map<String, Object> params, String key, String defVal) {
		Object v = params.get(key);
		if (v != null) {
			return StringUtils.trimToNull(String.valueOf(v));
		}
		return defVal;
	}

	/**
	 * get string param
	 *
	 * @param request
	 * @param key
	 * @return
	 */
	public static String getStr(HttpServletRequest request, String key) {
		return getStr(request, key, null);
	}

	/**
	 * get str with default value
	 *
	 * @param request
	 * @param key
	 * @param defVal
	 * @return
	 */
	public static String getStr(HttpServletRequest request, String key, String defVal) {
		String value = StringUtils.trimToNull(request.getParameter(key));
		if (StringUtils.isNotBlank(value)) {
			return value;
		}
		return defVal;
	}

	/**
	 * get none blank string param
	 *
	 * @param params
	 * @param key
	 * @return
	 */
	public static String getNoneBlankStr(Map<String, Object> params, String key) {
		String value = getStr(params, key);
		if (StringUtils.isBlank(value)) {
			throw new IllegalArgumentException(String.format("[%s] not exist.", key));
		}
		return value;
	}

	/**
	 * parse byte
	 *
	 * @param v
	 * @param defVal if not exist, return default value
	 * @return if exist return parsed value, or parse err return null
	 */
	public static Byte parseByte(Object v, Byte defVal) {
		if (v != null) {
			try {
				if (v instanceof Number) {
					return ((Number) v).byteValue();
				}
				if (v instanceof CharSequence) {
					return Byte.parseByte(String.valueOf(v));
				}
			} catch (NumberFormatException e) {
				throw new NumberFormatException(String.format("[%s] parse error.", v));
			}
			return null;
		}
		return defVal;
	}

	public static Integer getInt(HttpServletRequest request, String key) {
		return getInt(request, key, null);
	}

	public static Integer getInt(HttpServletRequest request, String key, Integer defVal) {
		String value = getStr(request, key);
		return parseInt(value, defVal);
	}

	public static Integer getInt(Map<String, Object> params, String key) {
		return getInt(params, key, null);
	}

	public static Integer getInt(Map<String, Object> params, String key, Integer defVal) {
		String value = getStr(params, key);
		return parseInt(value, defVal);
	}

	/**
	 * parse int
	 *
	 * @param v
	 * @param defVal if v not exist, return default value
	 * @return if exist return parsed value, or parse err return null
	 */
	public static Integer parseInt(Object v, Integer defVal) {
		if (v != null) {
			try {
				if (v instanceof Number) {
					return ((Number) v).intValue();
				}
				if (v instanceof CharSequence) {
					return Integer.parseInt(String.valueOf(v));
				}
			} catch (NumberFormatException e) {
				throw new NumberFormatException(String.format("[%s] parse error.", v));
			}
			return null;
		}
		return defVal;
	}

	public static Float getFloat(HttpServletRequest request, String key) {
		return getFloat(request, key, null);
	}

	public static Float getFloat(HttpServletRequest request, String key, Float defVal) {
		String value = getStr(request, key);
		return parseFloat(value, defVal);
	}

	public static Float getFloat(Map<String, Object> params, String key) {
		return getFloat(params, key, null);
	}

	public static Float getFloat(Map<String, Object> params, String key, Float defVal) {
		String value = getStr(params, key);
		return parseFloat(value, defVal);
	}

	/**
	 * parse float
	 *
	 * @param v
	 * @param defVal if not exist, return default value
	 * @return if exist return parsed value, or parse err return null
	 */
	public static Float parseFloat(Object v, Float defVal) {
		if (v != null) {
			try {
				if (v instanceof Number) {
					return ((Number) v).floatValue();
				}
				if (v instanceof CharSequence) {
					return Float.parseFloat(String.valueOf(v));
				}
			} catch (NumberFormatException e) {
				throw new NumberFormatException(String.format("[%s] parse error.", v));
			}
			return null;
		}
		return defVal;
	}

	public static Double getDouble(HttpServletRequest request, String key) {
		return getDouble(request, key, null);
	}

	public static Double getDouble(HttpServletRequest request, String key, Double defVal) {
		String value = getStr(request, key);
		return parseDouble(value, defVal);
	}

	public static Double getDouble(Map<String, Object> params, String key) {
		return getDouble(params, key, null);
	}

	public static Double getDouble(Map<String, Object> params, String key, Double defVal) {
		String value = getStr(params, key);
		return parseDouble(value, defVal);
	}

	/**
	 * parse double
	 *
	 * @param v
	 * @param defVal if not exist, return default value
	 * @return if exist return parsed value, or parse err return null
	 */
	public static Double parseDouble(Object v, Double defVal) {
		if (v != null) {
			try {
				if (v instanceof Number) {
					return ((Number) v).doubleValue();
				}
				if (v instanceof CharSequence) {
					return Double.parseDouble(String.valueOf(v));
				}
			} catch (NumberFormatException e) {
				throw new NumberFormatException(String.format("[%s] parse error.", v));
			}
			return null;
		}
		return defVal;
	}

	public static Long getLong(HttpServletRequest request, String key) {
		return getLong(request, key, null);
	}

	public static Long getLong(HttpServletRequest request, String key, Long defVal) {
		String value = getStr(request, key);
		return parseLong(value, defVal);
	}

	public static Long getLong(Map<String, Object> params, String key) {
		return getLong(params, key, null);
	}

	public static Long getLong(Map<String, Object> params, String key, Long defVal) {
		String value = getStr(params, key);
		return parseLong(value, defVal);
	}

	/**
	 * parse long
	 *
	 * @param v
	 * @param defVal if not exist, return default value
	 * @return if exist return parsed value, or parse err return null
	 */
	public static Long parseLong(Object v, Long defVal) {
		if (v != null) {
			try {
				if (v instanceof Number) {
					return ((Number) v).longValue();
				}
				if (v instanceof CharSequence) {
					return Long.parseLong(String.valueOf(v));
				}
			} catch (NumberFormatException e) {
				throw new NumberFormatException(String.format("[%s] parse error.", v));
			}
			return null;
		}
		return defVal;
	}
}
