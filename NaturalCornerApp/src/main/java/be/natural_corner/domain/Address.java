package be.natural_corner.domain;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.Transient;

@Embeddable
public class Address {
	@Transient
	private Long addressId;
	private String street;
	private String number;
	private String boxNumber;
	private String postCode;
	private String town;
	private String country;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Address(String street, String number, String boxNumber, String postCode, String town,
			String country) {
		super();
		this.street = street;
		this.number = number;
		this.boxNumber = boxNumber;
		this.postCode = postCode;
		this.town = town;
		this.country = country;
	}

	public Long getAddressId() {
		return addressId;
	}


	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}


	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String expected) {
		this.number = expected;
	}
	public String getBoxNumber() {
		return boxNumber;
	}
	public void setBoxNumber(String boxNumber) {
		this.boxNumber = boxNumber;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boxNumber == null) ? 0 : boxNumber.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((postCode == null) ? 0 : postCode.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((town == null) ? 0 : town.hashCode());
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
		Address other = (Address) obj;
		if (boxNumber == null) {
			if (other.boxNumber != null)
				return false;
		} else if (!boxNumber.equals(other.boxNumber))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;

		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (postCode == null) {
			if (other.postCode != null)
				return false;
		} else if (!postCode.equals(other.postCode))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (town == null) {
			if (other.town != null)
				return false;
		} else if (!town.equals(other.town))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Address [street=" + street + ", number=" + number + ", boxNumber=" + boxNumber
				+ ", postCode=" + postCode + ", town=" + town + ", country=" + country + "]";
	}
	
	
	
}
