package com.example.design.patterns.pattern.created.builder;

/**
 * @author clx
 */
public interface DecorationMenu {

	/**
	 * ceiling
	 *
	 * @param matter matter
	 * @return decoration menu
	 */
	DecorationMenu appendCeiling(Matter matter);

	/**
	 * coat
	 *
	 * @param matter matter
	 * @return decoration menu
	 */
	DecorationMenu appendCoat(Matter matter);

	/**
	 * floor
	 *
	 * @param matter matter
	 * @return decoration menu
	 */
	DecorationMenu appendFloor(Matter matter);

	/**
	 * tile
	 *
	 * @param matter matter
	 * @return decoration menu
	 */
	DecorationMenu appendTile(Matter matter);

	/**
	 * decoration detail
	 *
	 * @return detail
	 */
	String decorationDetail();
}
