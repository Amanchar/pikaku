package com.pikaku.core.services;

import com.pikaku.core.requests.AddProductRequest;
import com.pikaku.core.responses.AddProductResponse;
import com.pikaku.core.domain.CoreError;
import com.pikaku.core.services.validators.AddProductValidator;
import com.pikaku.database.DataBase;
import com.pikaku.matcher.ProductMatcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;

@ExtendWith (MockitoExtension.class)
class AddProductServiceTest {

	@Mock
	private DataBase database;
	@Mock
	private AddProductValidator validator;
	@InjectMocks
	private AddProductService service;

	@Test
	public void shouldReturnResponseWithErrorWhenValidationFails () {
		AddProductRequest request = new AddProductRequest (null, null);

		List<CoreError> errors
				= List.of (new CoreError ("productTitle", "product title is blank"));

		Mockito.when (validator.validate (request)).thenReturn (errors);

		AddProductResponse response = service.execute (request);

		assertTrue (response.hasErrors ());
		assertEquals (response.getErrors ().size (), 1);
		assertEquals (response.getErrors ().get (0).getField (), "productTitle");
		assertEquals (response.getErrors ().get (0).getMessage (), "product title is blank");

		Mockito.verifyNoInteractions (database);
	}

	@Test
	public void shouldAddProduct () {
		Mockito.when (validator.validate (any ())).thenReturn (new ArrayList<> ());

		AddProductRequest request = new AddProductRequest ("Piens", BigDecimal.valueOf (33.33));
		AddProductResponse response = service.execute (request);

		Mockito.verify (database).add (
				argThat (new ProductMatcher ("Piens", BigDecimal.valueOf (33.33)))
		);

		assertFalse (response.hasErrors ());
		assertNull (response.getErrors ());
	}
}