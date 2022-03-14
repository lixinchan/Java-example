package com.example.design.patterns.pattern.structural.composition.serivice.engine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.example.design.patterns.pattern.structural.composition.serivice.logic.LogicFilter;
import com.example.design.patterns.pattern.structural.composition.serivice.logic.impl.UserAgeFilter;
import com.example.design.patterns.pattern.structural.composition.serivice.logic.impl.UserGenderFilter;

/**
 * @author clx
 */
public class EngineConfig {

	private EngineConfig() {
	}

	static Map<String, LogicFilter> logicFilterMap;

	static {
		logicFilterMap = new ConcurrentHashMap<>();
		logicFilterMap.put("UserAge", new UserAgeFilter());
		logicFilterMap.put("UserGender", new UserGenderFilter());
	}

	public static Map<String, LogicFilter> getLogicFilterMap() {
		return logicFilterMap;
	}

	public static void setLogicFilterMap(Map<String, LogicFilter> logicFilterMap) {
		EngineConfig.logicFilterMap = logicFilterMap;
	}
}
