package com.pikaku.console_ui;

import com.pikaku.core.requests.GetProductRequest;
import com.pikaku.core.responses.GetProductResponse;
import com.pikaku.core.services.PrintAllProductService;

public class PrintAllProductsUIAction implements UIAction {

	private final PrintAllProductService printAllProductService;


	public PrintAllProductsUIAction (PrintAllProductService printAllProductService) {
		this.printAllProductService = printAllProductService;
	}

	@Override
	public void execute () {
		GetProductRequest request = new GetProductRequest (-1L);
		GetProductResponse response = printAllProductService.execute (request);
		if (response.hasErrors ())
			response.getErrors ().forEach (System.out::println);
		else
			response.getProductList ().forEach (System.out::println);
	}
}
