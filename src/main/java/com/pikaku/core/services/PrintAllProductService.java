package com.pikaku.core.services;

import com.pikaku.core.domain.CoreError;
import com.pikaku.database.DataBase;
import com.pikaku.core.requests.GetProductRequest;
import com.pikaku.core.responses.GetProductResponse;

import java.util.ArrayList;
import java.util.List;

public class PrintAllProductService {

	private final DataBase dataBase;


	public PrintAllProductService (DataBase dataBase) {
		this.dataBase = dataBase;
	}

	public GetProductResponse execute (GetProductRequest request) {
		if (request.getId () != -1L) {
			List<CoreError> errors = new ArrayList<> ();
			errors.add (new CoreError ("productId", "productId null"));
			new GetProductResponse (errors);
		}

		return new GetProductResponse (new ArrayList<> (), dataBase.getAll ());
	}
}
