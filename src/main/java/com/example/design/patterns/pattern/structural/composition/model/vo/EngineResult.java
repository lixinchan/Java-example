package com.example.design.patterns.pattern.structural.composition.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author clx
 */
@Data
@Accessors(chain = true)
public class EngineResult {
	/**
	 * user id
	 */
	private String uid;
	/**
	 * tree id
	 */
	private Long treeId;
	/**
	 * tree node id
	 */
	private Long treeNodeId;
	/**
	 * node value
	 */
	private String nodeVal;

	public EngineResult(String uid, Long treeId, Long treeNodeId, String nodeVal) {
		this.uid = uid;
		this.treeId = treeId;
		this.treeNodeId = treeNodeId;
		this.nodeVal = nodeVal;
	}
}
