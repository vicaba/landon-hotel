package com.vicaba.landonhotel.data.entity;

import static jakarta.persistence.GenerationType.AUTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "guest")
@Data
@ToString
public class Guest {

	@Id
	@Column(name = "guest_id")
	@GeneratedValue(strategy = AUTO)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email_address")
	private String emailAddress;

	@Column(name = "address")
	private String address;

	@Column(name = "country")
	private String country;

	@Column(name = "state")
	private String state;

	@Column(name = "phone_number")
	private String phoneNumber;

}

/*
 * CREATE TABLE GUEST( GUEST_ID BIGSERIAL PRIMARY KEY, FIRST_NAME VARCHAR(64), LAST_NAME
 * VARCHAR(64), EMAIL_ADDRESS VARCHAR(64), ADDRESS VARCHAR(64), COUNTRY VARCHAR(32), STATE
 * VARCHAR(12), PHONE_NUMBER VARCHAR(24) );
 */
