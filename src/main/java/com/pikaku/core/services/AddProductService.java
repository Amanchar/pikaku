package com.pikaku.core.services;

import com.pikaku.database.DataBase;
import com.pikaku.core.requests.AddProductRequest;
import com.pikaku.core.responses.AddProductResponse;
import com.pikaku.core.services.validators.AddProductValidator;
import com.pikaku.core.domain.CoreError;
import com.pikaku.core.domain.Product;

import java.util.List;

public class AddProductService {

	private final DataBase dataBase;
	private final AddProductValidator validator;


	public AddProductService (DataBase dataBase,
							  AddProductValidator validator) {
		this.dataBase = dataBase;
		this.validator = validator;
	}

	public AddProductResponse execute (final AddProductRequest request) {
		List<CoreError> errors;

		if ((errors = validator.validate (request)).size () > 0)
			return new AddProductResponse (errors);

		Product product = new Product (request.getTitle (), request.getPrice ());

		dataBase.add (product);

		return new AddProductResponse ();
	}
}
