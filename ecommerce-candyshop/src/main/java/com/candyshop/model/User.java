package com.candyshop.model;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private List<Adress> address = new ArrayList<>();
	
	
	private List<PaymentInformation> paymentInformation = new ArrayList<>();
