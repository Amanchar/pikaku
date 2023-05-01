package com.pikaku.core.services;

import com.pikaku.core.domain.CoreError;
import com.pikaku.core.domain.Product;
import com.pikaku.core.requests.DeleteProductRequest;
import com.pikaku.core.requests.GetProductRequest;
import com.pikaku.core.responses.DeleteProductResponse;
import com.pikaku.core.responses.GetProductResponse;
import com.pikaku.core.services.validators.GetProductValidator;
import com.pikaku.database.DataBase;

import java.util.ArrayList;
import java.util.List;

public class GetProductService {
	private final DataBase dataBase;
	private final GetProductValidator validator;

	public GetProductService (DataBase dataBase, GetProductValidator validator) {
		this.dataBase = dataBase;
		this.validator = validator;
	}

	public GetProductResponse execute (GetProductRequest request) {
		List<CoreError> errors;
		if ((errors = validator.validate (request)).size () > 0)
			return new GetProductResponse (errors);

		Product product = dataBase.getBy (request.getId ());
		if (product == null) {
			errors = new ArrayList<> ();
			errors.add (new CoreError ("id", "no such product"));
			return new GetProductResponse (errors);
		}
		return new GetProductResponse (errors, List.of (product));
	}
}
