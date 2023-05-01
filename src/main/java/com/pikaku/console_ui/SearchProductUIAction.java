package com.pikaku.console_ui;

import com.pikaku.core.requests.GetProductRequest;
import com.pikaku.core.responses.GetProductResponse;
import com.pikaku.core.services.GetProductService;

import java.util.Scanner;

public class SearchProductUIAction implements UIAction {

	private final GetProductService getProductService;

	public SearchProductUIAction (GetProductService getProductService) {
		this.getProductService = getProductService;
	}

	@Override
	public void execute () {
		Scanner scanner = new Scanner (System.in);
		System.out.println ("Enter product id: ");
		Long productId = scanner.nextLong ();

		GetProductRequest request = new GetProductRequest (productId);
		GetProductResponse response = getProductService.execute (request);

		if (response.hasErrors ())
			response.getErrors ().forEach (System.out::println);
		else
			System.out.println (response.getProductList ());
	}
}
