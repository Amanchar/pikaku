package com.pikaku.console_ui;

import com.pikaku.core.requests.DeleteProductRequest;
import com.pikaku.core.responses.DeleteProductResponse;
import com.pikaku.core.services.DeleteProductService;

import java.util.Scanner;

public class DeleteProductUIAction implements UIAction {

	private final DeleteProductService deleteProductService;


	public DeleteProductUIAction (DeleteProductService deleteProductService) {
		this.deleteProductService = deleteProductService;
	}

	@Override
	public void execute () {
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
