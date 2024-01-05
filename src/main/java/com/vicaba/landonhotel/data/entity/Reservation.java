package com.vicaba.landonhotel.data.entity;

import static jakarta.persistence.GenerationType.AUTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "reservation")
@Data
@ToString
public class Reservation {

	@Id
	@Column(name = "reservation_id")
	@GeneratedValue(strategy = AUTO)
	private Long id;

	@Column(name = "room_id")
	private Long roomId;

	@Column(name = "guest_id")
	private Long guestId;

	@Column(name = "res_date")
	private Date reservationDate;

}

/*
 * CREATE TABLE RESERVATION( RESERVATION_ID BIGSERIAL PRIMARY KEY, ROOM_ID BIGINT NOT
 * NULL, GUEST_ID BIGINT NOT NULL, RES_DATE DATE );
 */
