package com.example.commons.web;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author clx 2019-08-01
 */
public final class RequestUtils {
	private RequestUtils() {
	}

	public static String getRemoteAddr(HttpServletRequest request) {
		Enumeration<String> xForwardeds = request.getHeaders("X-Forwarded-For");
		while (xForwardeds.hasMoreElements()) {
			String xForwarded = xForwardeds.nextElement();
			if (StringUtils.isNotBlank(xForwarded)) {
				String[] ipArr = StringUtils.split(xForwarded, ',');
				if (ArrayUtils.isNotEmpty(ipArr)) {
					for (String ip : ipArr) {
						ip = StringUtils.trimToNull(ip);
						if (StringUtils.isNotBlank(ip)) {
							return ip;
						}
					}
				}
			}
		}
		return request.getRemoteAddr();
	}
}
