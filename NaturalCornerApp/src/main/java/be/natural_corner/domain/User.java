package be.natural_corner.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Users")
public class User {

	@Id
	@GeneratedValue
	private Long userId;
	private String firstName;
	private String lastName;
	private String nickName;
	private String password;
	@Embedded
	private Address address;
	private String eMailAddress;
	private String phone;
	private LocalDateTime inscriptionDateTime;
	private String ipAddress;
	public Long getId() {
		return userId;
	}
	public void setId(Long id) {
		this.userId = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String geteMailAddress() {
		return eMailAddress;
	}
	public void seteMailAddress(String eMailAddress) {
		this.eMailAddress = eMailAddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getInscriptionDateTime() {
		return inscriptionDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
	}
	public void setInscriptionDateTime(LocalDateTime inscriptionDateTime) {
		this.inscriptionDateTime = inscriptionDateTime;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public User() {
		super();
	}
	public User(String password, String eMailAddress) {
		super();
		this.firstName = "firstName";
		this.lastName = "lastName";
		this.nickName = "nickName";
		this.password = password;
		this.address = new Address("street", "number", "boxNumber", "postCode", "town", "country");
		this.eMailAddress = eMailAddress;
		this.phone = "phone";
		this.inscriptionDateTime = LocalDateTime.now();
		this.ipAddress = "111.111.111.111";
	}
	public User(Long id, String firstName, String lastName, String nickName, String password, Address address, String eMailAddress,
			String phone, LocalDateTime inscriptionDateTime, String ipAddress) {
		super();
		this.userId = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.password = password;
		this.address = address;
		this.eMailAddress = eMailAddress;
		this.phone = phone;
		this.inscriptionDateTime = inscriptionDateTime;
		this.ipAddress = ipAddress;
	}

	@Override
	public String toString() {
		return "User [id=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", nickName=" + nickName
				+ ", password=" + password + ", eMailAddress=" + eMailAddress + ", phone=" + phone
				+ ", inscriptionDateTime=" + inscriptionDateTime + ", ipAddress=" + ipAddress + "]";
	}

	
	
	
	
}
