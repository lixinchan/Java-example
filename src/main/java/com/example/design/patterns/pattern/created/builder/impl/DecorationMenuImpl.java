package com.example.design.patterns.pattern.created.builder.impl;

import com.example.design.patterns.pattern.created.builder.DecorationMenu;
import com.example.design.patterns.pattern.created.builder.Matter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author clx
 */
public class DecorationMenuImpl implements DecorationMenu {
	/**
	 * decoration list
	 */
	private List<Matter> decorationList = new ArrayList<>();
	/**
	 * decoration total price
	 */
	private BigDecimal decorationPrice = BigDecimal.ZERO;
	/**
	 * decoration area
	 */
	private BigDecimal decorationArea;
	/**
	 * decoration grade
	 */
	private String decorationGrade;

	private DecorationMenuImpl() {
	}

	public DecorationMenuImpl(Double decorationArea, String decorationGrade) {
		this.decorationArea = decorationPrice;
		this.decorationGrade = decorationGrade;
	}

	@Override
	public DecorationMenu appendCeiling(Matter matter) {
		decorationList.add(matter);
		decorationPrice = decorationPrice.add(decorationArea.multiply(new BigDecimal("")).multiply(matter.decorationPrice()));
		return this;
	}

	@Override
	public DecorationMenu appendCoat(Matter matter) {
		decorationList.add(matter);
		decorationPrice = decorationPrice.add(decorationArea.multiply(new BigDecimal("")).multiply(matter.decorationPrice()));
		return this;
	}

	@Override
	public DecorationMenu appendFloor(Matter matter) {
		decorationList.add(matter);
		decorationPrice = decorationPrice.add(decorationArea.multiply(matter.decorationPrice()));
		return this;
	}

	@Override
	public DecorationMenu appendTile(Matter matter) {
		decorationList.add(matter);
		decorationPrice = decorationPrice.add(decorationArea.multiply(matter.decorationPrice()));
		return this;
	}

	@Override
	public String decorationDetail() {
		StringBuilder detail = new StringBuilder(128);
		decorationList.forEach(e -> detail.append(e.scene()).append(':').append(e.brand()).append(':').append(e.model()).append(':').append(e.decorationPrice()));
		return detail.toString();
	}
}
