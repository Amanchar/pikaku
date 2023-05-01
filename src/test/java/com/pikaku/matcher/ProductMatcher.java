package com.pikaku.matcher;

import com.pikaku.core.domain.Product;
import org.mockito.ArgumentMatcher;

import java.math.BigDecimal;

public class ProductMatcher implements ArgumentMatcher<Product> {
	private final String title;
	private final BigDecimal price;

	public ProductMatcher (String title, BigDecimal price) {
		this.title = title;
		this.price = price;
	}

	@Override
	public boolean matches (Product argument) {
		return argument.getTitle ().equals (title)
				&& argument.getPrice ().equals (price);
	}
}
