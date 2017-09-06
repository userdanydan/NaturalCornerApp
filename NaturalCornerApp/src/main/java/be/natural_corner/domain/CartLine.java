package be.natural_corner.domain;

import java.math.BigDecimal;

public class CartLine {
	
	private int id;
	private int quantity;
	private Product product;
	private BigDecimal lineTotal;
	
	public CartLine() {
		// TODO Auto-generated constructor stub
	}

	public CartLine(int id, int quantity, Product product, BigDecimal lineTotal) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.product = product;
		this.lineTotal = lineTotal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public BigDecimal getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(BigDecimal lineTotal) {
		this.lineTotal = lineTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartLine other = (CartLine) obj;
		if (id != other.id)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CartLine [id=" + id + ", quantity=" + quantity + ", product=" + product + ", lineTotal=" + lineTotal
				+ "]";
	}
	
}
