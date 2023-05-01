package com.pikaku.core.services.validators;

import com.pikaku.core.requests.AddProductRequest;
import com.pikaku.core.domain.CoreError;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class AddProductValidator {

	public List<CoreError> validate (AddProductRequest request) {
		List<CoreError> errors = new ArrayList<> ();

		if (StringUtils.isBlank (request.getTitle ())) {
			CoreError error = new CoreError ("productTitle", "product title is blank");
			errors.add (error);
		}

		if (request.getPrice () == null) {
			CoreError error = new CoreError ("productPrice", "null");
			errors.add (error);
		}

		if (request.getPrice () != null && request.getPrice ().compareTo (BigDecimal.ZERO) == 0) {
			CoreError error = new CoreError ("productPrice", "productPrice is zero");
			errors.add (error);
		}

		if (request.getPrice () != null && request.getPrice ().compareTo (BigDecimal.ZERO) < 0) {
			CoreError error = new CoreError ("productPrice", "productPrice is less then zero");
			errors.add (error);
		}

		return errors;
	}

}
