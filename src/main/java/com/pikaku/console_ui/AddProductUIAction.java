package com.pikaku.console_ui;

import com.pikaku.core.requests.AddProductRequest;
import com.pikaku.core.responses.AddProductResponse;
import com.pikaku.core.services.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class AddProductUIAction implements UIAction {

	@Autowired private final AddProductService addProductService;


	public AddProductUIAction (AddProductService addProductService) {
		this.addProductService = addProductService;
	}

	@Override
	public void execute () {
		Scanner scanner = new Scanner (System.in);
		System.out.println ("Enter product title: ");
		String productTitle = scanner.nextLine ();
		System.out.println ("Enter product price: ");
		BigDecimal productPrice = scanner.nextBigDecimal ();

		AddProductRequest request = new AddProductRequest (productTitle, productPrice);
		AddProductResponse response = addProductService.execute (request);

		if (response.hasErrors ())
			response.getErrors ().forEach (System.out::println);
	}
}
