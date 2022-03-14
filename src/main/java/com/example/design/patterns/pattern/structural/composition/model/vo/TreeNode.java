package com.example.design.patterns.pattern.structural.composition.model.vo;

import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author clx
 */
@Data
@Accessors(chain = true)
public class TreeNode {
	/**
	 * tree id
	 */
	private Long treeId;
	/**
	 * tree node id
	 */
	private Long treeNodeId;
	/**
	 * node type
	 */
	private int nodeType;
	/**
	 * node value
	 */
	private String nodeVal;
	/**
	 * rule key
	 */
	private String ruleKey;
	/**
	 * rule desc
	 */
	private String ruleDesc;
	/**
	 * tree node link list
	 */
	private List<TreeNodeLink> treeNodeLinkList;
}
