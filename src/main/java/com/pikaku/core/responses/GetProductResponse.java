package com.pikaku.core.responses;

import com.pikaku.core.domain.CoreError;
import com.pikaku.core.domain.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class GetProductResponse extends ResponseBase {

	private final List<Product> productList = new ArrayList<> ();


	public GetProductResponse (List<CoreError> errors, List<Product> products) {
		super (errors);
		if (products != null)
			this.productList.addAll (products);
	}

	public GetProductResponse (List<CoreError> errors) {
		this (errors, null);
	}

}
