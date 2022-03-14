package com.example.design.patterns.pattern.structural.composition.serivice.logic;

import java.util.List;
import java.util.Map;

import com.example.design.patterns.pattern.structural.composition.model.vo.TreeNodeLink;

/**
 * @author clx
 */
public interface LogicFilter {
	/**
	 * do filter
	 *
	 * @param matterVal        matter value
	 * @param treeNodeLinkList matter node
	 * @return next tree id
	 */
	Long doFilter(String matterVal, List<TreeNodeLink> treeNodeLinkList);

	/**
	 * get matter value
	 *
	 * @param treeId         tree node id
	 * @param uid            userId
	 * @param decisionMatter decision matter
	 * @return matter value
	 */
	String getMatterVal(Long treeId, String uid, Map<String, String> decisionMatter);
}
