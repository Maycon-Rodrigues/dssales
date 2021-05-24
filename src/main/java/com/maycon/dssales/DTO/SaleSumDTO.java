package com.maycon.dssales.DTO;

import java.io.Serializable;

import com.maycon.dssales.entities.Seller;

public class SaleSumDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String sellerName;
	private Double sum;
	
	public SaleSumDTO() {}

	public SaleSumDTO(Seller entity, Double sum) {
		this.sellerName = entity.getName();
		this.sum = sum;
	}

	public String getName() {
		return sellerName;
	}

	public void setName(String name) {
		this.sellerName = name;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}
	
}
