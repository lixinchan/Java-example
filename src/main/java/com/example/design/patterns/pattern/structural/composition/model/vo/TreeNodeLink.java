package com.example.design.patterns.pattern.structural.composition.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author clx
 */
@Data
@Accessors(chain = true)
public class TreeNodeLink {
	/**
	 * source node id
	 */
	private Long nodeIdFrom;
	/**
	 * target node id
	 */
	private Long nodeIdTo;
	/**
	 * rule limit type
	 */
	private int ruleLimitType;
	/**
	 * rule limit value
	 */
	private String ruleLimitVal;
}
