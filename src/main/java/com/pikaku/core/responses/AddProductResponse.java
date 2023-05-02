package com.pikaku.core.responses;

import com.pikaku.core.domain.CoreError;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class AddProductResponse extends ResponseBase
{
	public AddProductResponse (List<CoreError> errors)
	{
		super (errors);
	}

}
