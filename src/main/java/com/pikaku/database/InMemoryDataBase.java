package com.pikaku.database;

import com.pikaku.core.domain.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryDataBase implements DataBase
{
	private static Long nextId = 1L;
	private final Map<Long, Product> database;


	public InMemoryDataBase ()
	{
		this.database = new HashMap<> ();
	}

	@Override
	public void add (Product product)
	{
		if (!database.containsKey (product.getId ()))
		{
			product.setId (nextId++);

			database.put (product.getId (), product);
		}
	}

	@Override
	public Product getBy (Long id)
	{
		return database.get (id);
	}

	@Override
	public void deleteBy (Long id)
	{
		database.remove (id);
	}

	@Override
	public List<Product> getAll ()
	{
		return new ArrayList<> (database.values ());
	}

}
