package com.example.design.patterns.pattern.structural.composition.serivice.engine;

import java.util.Map;

import com.example.design.patterns.pattern.structural.composition.model.TreeComposition;
import com.example.design.patterns.pattern.structural.composition.model.vo.EngineResult;

/**
 * @author clx
 */
public interface Engine {

	/**
	 * matter engine process
	 *
	 * @param treeId          tree id
	 * @param uid             user id
	 * @param treeComposition {@link TreeComposition}
	 * @param decisionMatter  decision matter
	 * @return {@link EngineResult}
	 */
	EngineResult process(final Long treeId, final String uid, TreeComposition treeComposition,
			final Map<String, String> decisionMatter);
}
