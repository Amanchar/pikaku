package com.pikaku.core.services;

import com.pikaku.core.domain.CoreError;
import com.pikaku.core.services.validators.DeleteProductValidator;
import com.pikaku.database.DataBase;
import com.pikaku.core.requests.DeleteProductRequest;
import com.pikaku.core.responses.DeleteProductResponse;

import java.util.List;

public class DeleteProductService {

	private final DataBase dataBase;
	private final DeleteProductValidator validator;


	public DeleteProductService (DataBase dataBase, DeleteProductValidator validator) {
		this.dataBase = dataBase;
		this.validator = validator;
	}

	public DeleteProductResponse execute (DeleteProductRequest request) {
		List<CoreError> errors;
		if ((errors = validator.validate (request)).size () > 0)
			return new DeleteProductResponse (errors);

		dataBase.deleteBy (request.getId ());

		return new DeleteProductResponse ();
	}
}
