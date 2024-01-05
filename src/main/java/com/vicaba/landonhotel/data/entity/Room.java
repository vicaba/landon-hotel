package com.vicaba.landonhotel.data.entity;

import static jakarta.persistence.GenerationType.AUTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "room")
@Data
@ToString
@Getter
public class Room {

	@Id
	@Column(name = "room_id")
	@GeneratedValue(strategy = AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "room_number")
	private String roomNumber;

	@Column(name = "bed_info")
	private String bedInfo;

	public Room(long id, String name, String roomNumber, String bedInfo) {
		this.id = id;
		this.name = name;
		this.roomNumber = roomNumber;
		this.bedInfo = bedInfo;
	}

	protected Room() {

	}

}
