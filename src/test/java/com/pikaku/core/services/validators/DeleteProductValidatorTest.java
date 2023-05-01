package com.pikaku.core.services.validators;

import com.pikaku.core.requests.DeleteProductRequest;
import com.pikaku.core.domain.CoreError;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteProductValidatorTest {

	private final DeleteProductValidator validator = new DeleteProductValidator ();

	@Test
	public void successValidationTest () {
		DeleteProductRequest request = new DeleteProductRequest (1L);

		List<CoreError> errors = validator.validate (request);

		assertEquals (errors.size (), 0);
	}

	@Test
	public void nullIdValidationTest () {
		DeleteProductRequest request = new DeleteProductRequest (null);

		List<CoreError> errors = validator.validate (request);

		assertEquals (errors.size (), 1);
		assertEquals (errors.get (0).getField (), "productId");
		assertEquals (errors.get (0).getMessage (), "productId null");
	}

	@Test
	public void zeroIdValidationTest () {
		DeleteProductRequest request = new DeleteProductRequest (0L);

		List<CoreError> errors = validator.validate (request);

		assertEquals (errors.size (), 1);
		assertEquals (errors.get (0).getField (), "productId");
		assertEquals (errors.get (0).getMessage (), "product id cannot be zero or negative");
	}

	@Test
	public void negativeIdValidationTest () {
		DeleteProductRequest request = new DeleteProductRequest (-1L);

		List<CoreError> errors = validator.validate (request);

		assertEquals (errors.size (), 1);
		assertEquals (errors.get (0).getField (), "productId");
		assertEquals (errors.get (0).getMessage (), "product id cannot be zero or negative");
	}
}