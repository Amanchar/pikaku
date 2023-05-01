package com.pikaku.console_ui;

import com.pikaku.core.requests.PrintAllRequest;
import com.pikaku.core.requests.ProductRequest;
import com.pikaku.core.responses.ProductResponse;
import com.pikaku.core.services.PrintAllProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintAllProductsUIAction implements UIAction {

	@Autowired private final PrintAllProductService printAllProductService;


	public PrintAllProductsUIAction (PrintAllProductService printAllProductService) {
		this.printAllProductService = printAllProductService;
	}

	@Override
	public void execute () {
		ProductResponse response = printAllProductService.execute (new PrintAllRequest ());
		if (response.hasErrors ())
			response.getErrors ().forEach (System.out::println);
		else
			response.getProducts ().forEach (System.out::println);
	}
}
