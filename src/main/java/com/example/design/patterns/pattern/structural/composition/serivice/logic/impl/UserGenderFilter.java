package com.example.design.patterns.pattern.structural.composition.serivice.logic.impl;

import java.util.Map;

/**
 * @author clx
 */
public class UserGenderFilter extends BaseFilter {

	@Override
	public String getMatterVal(Long treeId, String uid, Map<String, String> decisionMatter) {
		return decisionMatter.get("gender");
	}
}
