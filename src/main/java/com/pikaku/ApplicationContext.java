package com.pikaku;

import com.pikaku.console_ui.*;
import com.pikaku.core.services.AddProductService;
import com.pikaku.core.services.DeleteProductService;
import com.pikaku.core.services.GetProductService;
import com.pikaku.core.services.PrintAllProductService;
import com.pikaku.core.services.validators.AddProductValidator;
import com.pikaku.core.services.validators.DeleteProductValidator;
import com.pikaku.core.services.validators.GetProductValidator;
import com.pikaku.database.DataBase;
import com.pikaku.database.InMemoryDataBase;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

	private final Map<Class, Object> beans = new HashMap<> ();

	public ApplicationContext () {
		beans.put (DataBase.class, new InMemoryDataBase ());

		beans.put (AddProductValidator.class, new AddProductValidator ());
		beans.put (AddProductService.class,
				new AddProductService (getBean (DataBase.class), getBean (AddProductValidator.class)));
		beans.put (AddProductUIAction.class, new AddProductUIAction (getBean (AddProductService.class)));

		beans.put (DeleteProductValidator.class, new DeleteProductValidator ());
		beans.put (DeleteProductService.class,
				new DeleteProductService (getBean (DataBase.class), getBean (DeleteProductValidator.class)));
		beans.put (DeleteProductUIAction.class, new DeleteProductUIAction (getBean (DeleteProductService.class)));

		beans.put (GetProductValidator.class, new GetProductValidator ());
		beans.put (GetProductService.class,
				new GetProductService (getBean (DataBase.class), getBean (GetProductValidator.class)));
		beans.put (SearchProductUIAction.class, new SearchProductUIAction (getBean (GetProductService.class)));

		beans.put (PrintAllProductService.class, new PrintAllProductService (getBean (DataBase.class)));
		beans.put (PrintAllProductsUIAction.class, new PrintAllProductsUIAction (getBean (PrintAllProductService.class)));
	}

	public <T extends Object> T getBean (Class c) {
		return (T) beans.get (c);
	}
}
