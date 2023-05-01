package com.pikaku.core.responses;

import com.pikaku.core.domain.CoreError;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class DeleteProductResponse extends ResponseBase {

	public DeleteProductResponse (List<CoreError> errors) {
		super (errors);
	}
}
