package com.pikaku.core.services;

import com.pikaku.database.DataBase;
import com.pikaku.core.requests.AddProductRequest;
import com.pikaku.core.responses.AddProductResponse;
import com.pikaku.core.services.validators.AddProductValidator;
import com.pikaku.core.domain.CoreError;
import com.pikaku.core.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddProductService
{
	@Autowired private final DataBase dataBase;
	@Autowired private final AddProductValidator validator;


	public AddProductService (DataBase dataBase,
							  AddProductValidator validator)
	{
		this.dataBase = dataBase;
		this.validator = validator;
	}

	public AddProductResponse execute (final AddProductRequest request)
	{
		List<CoreError> errors;

		if ((errors = validator.validate (request)).size () > 0)
			return new AddProductResponse (errors);

		dataBase.add (new Product (request.getTitle (), request.getPrice ()));

		return new AddProductResponse ();
	}

}
