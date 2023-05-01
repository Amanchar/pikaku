package com.pikaku.core.services;

import com.pikaku.core.domain.CoreError;
import com.pikaku.core.domain.Product;
import com.pikaku.core.requests.ProductRequest;
import com.pikaku.core.responses.ProductResponse;
import com.pikaku.core.services.validators.GetProductValidator;
import com.pikaku.database.DataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetProductService {

	@Autowired private final DataBase dataBase;
	@Autowired private final GetProductValidator validator;


	public GetProductService (DataBase dataBase, GetProductValidator validator) {
		this.dataBase = dataBase;
		this.validator = validator;
	}

	public ProductResponse execute (ProductRequest request) {
		List<CoreError> errors;
		if ((errors = validator.validate (request)).size () > 0)
			return new ProductResponse (errors, null);

		Product product = dataBase.getBy (request.getId ());
		if (product == null) {
			errors = new ArrayList<> ();
			errors.add (new CoreError ("id", "no such product"));
			return new ProductResponse (errors, null);
		}

		return new ProductResponse (errors, List.of (product));
	}
}
