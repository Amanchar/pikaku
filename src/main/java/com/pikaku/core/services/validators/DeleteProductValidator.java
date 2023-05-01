package com.pikaku.core.services.validators;

import com.pikaku.core.requests.DeleteProductRequest;
import com.pikaku.core.domain.CoreError;

import java.util.ArrayList;
import java.util.List;

public class DeleteProductValidator {

	public List<CoreError> validate (DeleteProductRequest request) {
		List<CoreError> errors = new ArrayList<> ();

		if (request.getId () == null) {
			CoreError error = new CoreError ("productId", "productId null");
			errors.add (error);
		}

		if (request.getId () != null && request.getId () <= 0) {
			CoreError error = new CoreError ("productId", "product id cannot be zero or negative");
			errors.add (error);
		}

		return errors;
	}
}
