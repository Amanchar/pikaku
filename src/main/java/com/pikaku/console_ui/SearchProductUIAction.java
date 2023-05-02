package com.pikaku.console_ui;

import com.pikaku.core.requests.ProductRequest;
import com.pikaku.core.responses.ProductResponse;
import com.pikaku.core.services.GetProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class SearchProductUIAction implements UIAction
{
	@Autowired private final GetProductService getProductService;

	public SearchProductUIAction (GetProductService getProductService)
	{
		this.getProductService = getProductService;
	}

	@Override
	public void execute ()
	{
		Scanner scanner = new Scanner (System.in);
		System.out.println ("Enter product id: ");
		Long productId = scanner.nextLong ();

		ProductRequest request = new ProductRequest (productId);
		ProductResponse response = getProductService.execute (request);

		if (response.hasErrors ())
			response.getErrors ().forEach (System.out::println);
		else
			System.out.println (response.getProducts ());
	}

}
