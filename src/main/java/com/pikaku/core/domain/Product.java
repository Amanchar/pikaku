package com.pikaku.core.domain;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Product
{
	private Long id;
	private String title;
	private BigDecimal price;


	public Product (String title, BigDecimal price)
	{
		this.title = title;
		this.price = price;
	}
}
