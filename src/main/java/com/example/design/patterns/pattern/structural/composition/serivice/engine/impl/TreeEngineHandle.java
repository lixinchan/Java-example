package com.example.design.patterns.pattern.structural.composition.serivice.engine.impl;

import java.util.Map;

import com.example.design.patterns.pattern.structural.composition.model.TreeComposition;
import com.example.design.patterns.pattern.structural.composition.model.vo.EngineResult;
import com.example.design.patterns.pattern.structural.composition.model.vo.TreeNode;

/**
 * @author clx
 */
public class TreeEngineHandle extends BaseEngine {

	@Override
	public EngineResult process(Long treeId, String uid, TreeComposition treeComposition,
			Map<String, String> decisionMatter) {
		TreeNode treeNode = this.engineDecision(treeComposition, treeId, uid, decisionMatter);
		return new EngineResult(uid, treeId, treeNode.getTreeNodeId(), treeNode.getNodeVal());
	}
}
