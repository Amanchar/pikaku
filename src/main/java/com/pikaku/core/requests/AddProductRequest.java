package com.pikaku.core.requests;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class AddProductRequest {
	private String title;
	private BigDecimal price;
}
