package be.natural_corner.domain;

import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="Products")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long productId;
	@NotNull
	private String productName;
	private BigDecimal unitPrice;
	private String comment;
	private boolean isAvailable;
	private boolean isDiscount;
//	@ManyToMany
//	private Category category;
	@Embedded
	private Section section;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(Long productId, String productName, BigDecimal unitPrice, String comment, boolean isAvailable,
			boolean isDiscount/*, Category category, Section section*/) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.comment = comment;
		this.isAvailable = isAvailable;
		this.isDiscount = isDiscount;
//		this.category = category;
//		this.section = section;
	}
	
	

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long id) {
		this.productId = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public boolean isDiscount() {
		return isDiscount;
	}

	public void setDiscount(boolean isDiscount) {
		this.isDiscount = isDiscount;
	}
//
//	public Category getCategory() {
//		return category;
//	}

//	public void setCategory(Category category) {
//		this.category = category;
//	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}


	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((section == null) ? 0 : section.hashCode());
		result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
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
		Product other = (Product) obj;
//		if (category == null) {
//			if (other.category != null)
//				return false;
//		} else if (!category.equals(other.category))
//			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		if (unitPrice == null) {
			if (other.unitPrice != null)
				return false;
		} else if (!unitPrice.equals(other.unitPrice))
			return false;
		return true;
	}


	


	@Override
	public String toString() {
		return "Product [id=" + productId + ", productName=" + productName + ", unitPrice=" + unitPrice + ", comment="
				+ comment + ", isAvailable=" + isAvailable + ", isDiscount=" + isDiscount + /*", category=" + category
				+ */", section=" + section + "]";
	}




	@Embeddable
	class Section{
		@Transient
		private Long sectionId;
		private String sectionName;
		
		public Section() {
			// TODO Auto-generated constructor stub
		}
		public Section(Long id, String sectionName) {
			super();
			this.sectionId=id;
			this.sectionName = sectionName;
		}
		public Long getId() {
			return sectionId;
		}
		public void setId(Long id) {
			this.sectionId = id;
		}
		public String getSectionName() {
			return sectionName;
		}
		public void setSectionName(String sectionName) {
			this.sectionName = sectionName;
		}
		@Override
		public String toString() {
			return "Section [id=" + sectionId + ", sectionName=" + sectionName + "]";
		}
		
	}
	
	
}
