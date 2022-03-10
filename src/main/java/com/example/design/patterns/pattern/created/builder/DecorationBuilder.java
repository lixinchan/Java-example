package com.example.design.patterns.pattern.created.builder;

import java.math.BigDecimal;

import com.example.design.patterns.pattern.created.builder.impl.DecorationMenuImpl;

/**
 * @author clx
 */
public class DecorationBuilder {

	/**
	 * level zero decoration
	 *
	 * @param area decoration area
	 * @return {@link DecorationMenu}
	 */
	public DecorationMenu levelZero(Double area) {
		return new DecorationMenuImpl(area, "").appendCeiling(new Matter() {
			@Override
			public String scene() {
				return null;
			}

			@Override
			public String brand() {
				return null;
			}

			@Override
			public String model() {
				return null;
			}

			@Override
			public BigDecimal decorationPrice() {
				return null;
			}

			@Override
			public String decorationDesc() {
				return null;
			}
		});
	}
}
