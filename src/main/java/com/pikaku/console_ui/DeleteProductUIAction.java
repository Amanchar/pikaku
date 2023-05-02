package com.pikaku.console_ui;

import com.pikaku.core.requests.DeleteProductRequest;
import com.pikaku.core.responses.DeleteProductResponse;
import com.pikaku.core.services.DeleteProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DeleteProductUIAction implements UIAction
{
	@Autowired private final DeleteProductService deleteProductService;


	public DeleteProductUIAction (DeleteProductService deleteProductService)
	{
		this.deleteProductService = deleteProductService;
	}

	@Override
	public void execute ()
	{
		System.out.println ("Enter product id: ");
		Scanner scanner = new Scanner (System.in);
		Long productId = scanner.nextLong ();

		DeleteProductRequest request = new DeleteProductRequest (productId);
		DeleteProductResponse response = deleteProductService.execute (request);

		if (response.hasErrors ())
			response.getErrors ().forEach (System.out::println);
		else
			System.out.printf ("Product with Id %d%n was deleted\n", productId);
	}

}
