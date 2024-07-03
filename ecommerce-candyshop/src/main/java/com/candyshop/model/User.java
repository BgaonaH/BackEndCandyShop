package com.candyshop.model;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private String firstName;
	
	private String lastName;
	
	private String password;
	
	private String email;
	
	private String role;

	private String mobile;
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private List<Address> address = new ArrayList<>();
	
	@Embedded
	@ElementCollection
	@CollectionTable(name="payment_information",joinColumns= @JoinColumn(name="user_id"))
	private List<PaymentInformation> paymentInformation = new ArrayList<>();
	
	@OneToMany(mappedBy="user",cascade= CascadeType.ALL)
	@JsonIgnore
	private List<Rating>ratings=new ArrayList<>();
	
	@OneToMany(mappedBy="user",cascade= CascadeType.ALL)
	@JsonIgnore
	private List<Review>rivews = new ArrayList<>();
	
	private LocalDateTime createAt;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param email
	 * @param role
	 * @param mobile
	 * @param address
	 * @param paymentInformation
	 * @param ratings
	 * @param rivews
	 * @param createAt
	 */
	public User(Long id, String firstName, String lastName, String password, String email, String role, String mobile,
			List<Address> address, List<PaymentInformation> paymentInformation, List<Rating> ratings,
			List<Review> rivews, LocalDateTime createAt) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.role = role;
		this.mobile = mobile;
		this.address = address;
		this.paymentInformation = paymentInformation;
		this.ratings = ratings;
		this.rivews = rivews;
		this.createAt = createAt;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<PaymentInformation> getPaymentInformation() {
		return paymentInformation;
	}

	public void setPaymentInformation(List<PaymentInformation> paymentInformation) {
		this.paymentInformation = paymentInformation;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Review> getRivews() {
		return rivews;
	}

	public void setRivews(List<Review> rivews) {
		this.rivews = rivews;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}
	
}