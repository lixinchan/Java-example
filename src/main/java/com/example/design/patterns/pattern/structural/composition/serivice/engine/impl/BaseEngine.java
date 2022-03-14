package com.example.design.patterns.pattern.structural.composition.serivice.engine.impl;

import java.util.Map;

import com.example.design.patterns.pattern.structural.composition.model.TreeComposition;
import com.example.design.patterns.pattern.structural.composition.model.vo.TreeNode;
import com.example.design.patterns.pattern.structural.composition.model.vo.TreeRoot;
import com.example.design.patterns.pattern.structural.composition.serivice.engine.Engine;
import com.example.design.patterns.pattern.structural.composition.serivice.engine.EngineConfig;
import com.example.design.patterns.pattern.structural.composition.serivice.logic.LogicFilter;

/**
 * @author clx
 */
public abstract class BaseEngine implements Engine {

	/**
	 * engine decision
	 *
	 * @param treeComposition {@link TreeComposition}
	 * @param treeId          tree id
	 * @param uid             user id
	 * @param decisionMatter  matter
	 * @return {@link TreeNode}
	 */
	protected TreeNode engineDecision(TreeComposition treeComposition, Long treeId, String uid,
			Map<String, String> decisionMatter) {
		TreeRoot treeRoot = treeComposition.getTreeRoot();
		Map<Long, TreeNode> treeNodeMap = treeComposition.getTreeNodeMap();
		Long rootNodeId = treeRoot.getTreeRootNodeId();
		TreeNode treeNode = treeNodeMap.get(rootNodeId);
		while (treeNode.getNodeType() == 1) {
			String ruleKey = treeNode.getRuleKey();
			LogicFilter logicFilter = EngineConfig.getLogicFilterMap().get(ruleKey);
			String matterVal = logicFilter.getMatterVal(treeId, uid, decisionMatter);
			Long nextNode = logicFilter.doFilter(matterVal, treeNode.getTreeNodeLinkList());
			treeNode = treeNodeMap.get(nextNode);
		}
		return treeNode;
	}
}
