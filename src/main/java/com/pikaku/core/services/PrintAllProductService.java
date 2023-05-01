package com.pikaku.core.services;

import com.pikaku.core.domain.CoreError;
import com.pikaku.core.requests.PrintAllRequest;
import com.pikaku.core.responses.ProductResponse;
import com.pikaku.database.DataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PrintAllProductService {

	@Autowired private final DataBase dataBase;


	public PrintAllProductService (DataBase dataBase) {
		this.dataBase = dataBase;
	}

	public ProductResponse execute (PrintAllRequest request) {
		if (request == null) {
			CoreError error = new CoreError ("null", "no request");

			List<CoreError> errors = new ArrayList<> ();
			errors.add (error);

			return new ProductResponse (errors, null);
		}
		return new ProductResponse (new ArrayList<> (), dataBase.getAll ());
	}
}
