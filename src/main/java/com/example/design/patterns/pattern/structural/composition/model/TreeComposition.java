package com.example.design.patterns.pattern.structural.composition.model;

import java.util.Map;

import com.example.design.patterns.pattern.structural.composition.model.vo.TreeNode;
import com.example.design.patterns.pattern.structural.composition.model.vo.TreeRoot;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author clx
 */
@Data
@Accessors(chain = true)
public class TreeComposition {

	/**
	 * {@link TreeRoot}
	 */
	private TreeRoot treeRoot;
	/**
	 * tree node map
	 */
	private Map<Long, TreeNode> treeNodeMap;
	/**
	 * tree root node id
	 */
	private Long treeRootNodeId;
}
