package com.pikaku.core.services.validators;

import com.pikaku.core.requests.AddProductRequest;
import com.pikaku.core.domain.CoreError;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddProductValidatorTest {

	private final AddProductValidator validator = new AddProductValidator ();

	@Test
	public void validationWithoutErrorTest () {
		AddProductRequest request = new AddProductRequest ("Title", new BigDecimal ("9.99"));

		List<CoreError> errors = validator.validate (request);

		assertEquals (errors.size (), 0);
	}

	@Test
	public void nullTitleTest () {
		AddProductRequest request = new AddProductRequest (null, new BigDecimal ("9.99"));

		List<CoreError> errors = validator.validate (request);

		assertEquals (errors.size (), 1);
		assertEquals (errors.get (0).getField (), "productTitle");
		assertEquals (errors.get (0).getMessage (), "null or empty");
	}

	@Test
	public void emptyTitleTest () {
		AddProductRequest request = new AddProductRequest ("", new BigDecimal ("9.99"));

		List<CoreError> errors = validator.validate (request);

		assertEquals (errors.size (), 1);
		assertEquals (errors.get (0).getField (), "productTitle");
		assertEquals (errors.get (0).getMessage (), "null or empty");
	}

	@Test
	public void nullPriceTest () {
		AddProductRequest request = new AddProductRequest ("Title Ok", null);

		List<CoreError> errors = validator.validate (request);

		assertEquals (errors.size (), 1);
		assertEquals (errors.get (0).getField (), "productPrice");
		assertEquals (errors.get (0).getMessage (), "null");
	}

	@Test
	public void zeroPriceTest () {
		AddProductRequest request = new AddProductRequest ("Title Ok", new BigDecimal ("0.00"));

		List<CoreError> errors = validator.validate (request);

		assertEquals (errors.size (), 1);
		assertEquals (errors.get (0).getField (), "productPrice");
		assertEquals (errors.get (0).getMessage (), "productPrice is zero");
	}

	@Test
	public void lessThenZeroPriceTest () {
		AddProductRequest request = new AddProductRequest ("Title Ok", new BigDecimal ("-1.00"));

		List<CoreError> errors = validator.validate (request);

		assertEquals (errors.size (), 1);
		assertEquals (errors.get (0).getField (), "productPrice");
		assertEquals (errors.get (0).getMessage (), "productPrice is less then zero");
	}

	@Test
	public void nullBothTitleAndPriceTest () {
		AddProductRequest request = new AddProductRequest (null, null);

		List<CoreError> errors = validator.validate (request);

		assertEquals (errors.size (), 2);
		assertEquals (errors.get (0).getField (), "productTitle");
		assertEquals (errors.get (0).getMessage (), "null or empty");

		assertEquals (errors.get (1).getField (), "productPrice");
		assertEquals (errors.get (1).getMessage (), "null");
	}
}