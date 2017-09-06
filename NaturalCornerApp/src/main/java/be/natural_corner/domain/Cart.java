package be.natural_corner.domain;

import java.math.BigDecimal;
import java.util.List;

public class Cart {
	
	private int id;
	private int articlesCount;
	private BigDecimal total;
	private List<CartLine> cartLines;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(int id, int articlesCount, BigDecimal total, List<CartLine> cartLines) {
		super();
		this.id = id;
		this.articlesCount = articlesCount;
		this.total = total;
		this.cartLines = cartLines;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArticlesCount() {
		return articlesCount;
	}

	public void setArticlesCount(int articlesCount) {
		this.articlesCount = articlesCount;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<CartLine> getCartLines() {
		return cartLines;
	}

	public void setCartLines(List<CartLine> cartLines) {
		this.cartLines = cartLines;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", articlesCount=" + articlesCount + ", total=" + total + ", cartLines=" + cartLines
				+ "]";
	}
	
	

}
