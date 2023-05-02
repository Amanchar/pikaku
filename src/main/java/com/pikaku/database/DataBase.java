package com.pikaku.database;

import com.pikaku.core.domain.Product;

import java.util.List;

public interface DataBase
{
	void add (Product product);

	Product getBy (Long id);

	void deleteBy (Long id);

	List<Product> getAll ();

}
