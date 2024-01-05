package com.vicaba.landonhotel.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoomReservation {

	private Long roomId;

	private Long guestId;

	private Long reservationId;

	private String roomName;

	private String roomNumber;

	private String firstName;

	private String lastName;

	private String reservationDate;

}
