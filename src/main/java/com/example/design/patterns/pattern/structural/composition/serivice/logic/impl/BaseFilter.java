package com.example.design.patterns.pattern.structural.composition.serivice.logic.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import com.example.design.patterns.pattern.structural.composition.model.vo.TreeNodeLink;
import com.example.design.patterns.pattern.structural.composition.serivice.logic.LogicFilter;

/**
 * @author clx
 */
public abstract class BaseFilter implements LogicFilter {

	@Override
	public Long doFilter(String matterVal, List<TreeNodeLink> treeNodeLinkList) {
		AtomicReference<Long> nextTreeId = new AtomicReference<>(0L);
		treeNodeLinkList.forEach(nodeLink -> {
			if (this.decisionLogic(matterVal, nodeLink)) {
				nextTreeId.set(nodeLink.getNodeIdTo());
			}
		});
		return nextTreeId.get();
	}

	/**
	 * get matter value
	 *
	 * @param treeId         tree node id
	 * @param uid            userId
	 * @param decisionMatter decision matter
	 * @return matter value
	 */
	@Override
	public abstract String getMatterVal(Long treeId, String uid, Map<String, String> decisionMatter);

	private boolean decisionLogic(String matterVal, TreeNodeLink nodeLink) {
		switch (nodeLink.getRuleLimitType()) {
		case 1:
			return matterVal.equals(nodeLink.getRuleLimitVal());
		case 2:
			return Double.parseDouble(matterVal) > Double.parseDouble(nodeLink.getRuleLimitVal());
		case 3:
			return Double.parseDouble(matterVal) < Double.parseDouble(nodeLink.getRuleLimitVal());
		case 4:
			return Double.parseDouble(matterVal) >= Double.parseDouble(nodeLink.getRuleLimitVal());
		case 5:
			return Double.parseDouble(matterVal) <= Double.parseDouble(nodeLink.getRuleLimitVal());
		default:
			return false;
		}
	}
}
