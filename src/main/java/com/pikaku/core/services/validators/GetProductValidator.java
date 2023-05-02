package com.pikaku.core.services.validators;

import com.pikaku.core.domain.CoreError;
import com.pikaku.core.requests.ProductRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetProductValidator
{
	public List<CoreError> validate (ProductRequest request)
	{
		List<CoreError> errors = new ArrayList<> ();

		if (request.getId () == null)
		{
			CoreError error = new CoreError ("productId", "productId null");
			errors.add (error);
		}

		if (request.getId () != null && request.getId () <= 0)
		{
			CoreError error = new CoreError ("productId", "product id cannot be zero or negative");
			errors.add (error);
		}

		return errors;
	}

}
