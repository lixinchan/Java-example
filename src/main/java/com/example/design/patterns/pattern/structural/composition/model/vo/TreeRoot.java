package com.example.design.patterns.pattern.structural.composition.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author clx
 */
@Data
@Accessors(chain = true)
public class TreeRoot {
	/**
	 * tree id
	 */
	private Long treeId;
	/**
	 * root node id
	 */
	private Long treeRootNodeId;
	/**
	 * tree name
	 */
	private String treeName;
}
