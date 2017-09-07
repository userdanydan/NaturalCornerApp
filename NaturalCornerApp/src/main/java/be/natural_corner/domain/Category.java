package be.natural_corner.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//@Entity
//@Table(name="Categories")
public class Category {
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryId;
//	@NotNull
	private String categoryName;
//	@OneToMany
	private Category subCategory;
	public Category() {
		// TODO Auto-generated constructor stub
	}
	public Category(Long id, String categoryName, Category subCategory) {
		super();
		this.categoryId = id;
		this.categoryName = categoryName;
		this.subCategory = subCategory;
	}
	public Long getId() {
		return this.categoryId;
	}
	public void setId(Long id) {
		this.categoryId = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Category getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(Category subCategory) {
		this.subCategory = subCategory;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((subCategory == null) ? 0 : subCategory.hashCode());
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
		Category other = (Category) obj;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (subCategory == null) {
			if (other.subCategory != null)
				return false;
		} else if (!subCategory.equals(other.subCategory))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Category [id=" + categoryId + ", categoryName=" + categoryName + ", subCategory=" + subCategory + "]";
	}
	
}
