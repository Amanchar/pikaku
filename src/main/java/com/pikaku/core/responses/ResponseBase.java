package com.pikaku.core.responses;

import com.pikaku.core.domain.CoreError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class ResponseBase
{
	private List<CoreError> errors;

	public boolean hasErrors ()
	{
		return errors != null && errors.size () > 0;
	}

}
