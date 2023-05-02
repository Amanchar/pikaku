package com.pikaku.core.responses;

import com.pikaku.core.domain.CoreError;
import com.pikaku.core.domain.Product;
import lombok.Getter;

import java.util.List;

@Getter
public class ProductResponse extends ResponseBase
{
	private final List<Product> products;


	public ProductResponse (List<CoreError> errors, List<Product> products)
	{
		super (errors);

		this.products = products;
	}

}
