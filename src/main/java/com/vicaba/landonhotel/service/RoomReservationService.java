package com.vicaba.landonhotel.service;

import com.vicaba.landonhotel.data.repository.GuestRepository;
import com.vicaba.landonhotel.data.repository.ReservationRepository;
import com.vicaba.landonhotel.data.repository.RoomRepository;
import com.vicaba.landonhotel.service.model.RoomReservation;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class RoomReservationService {

	private final GuestRepository guestRepository;

	private final RoomRepository roomRepository;

	private final ReservationRepository reservationRepository;

	public RoomReservationService(GuestRepository guestRepository, RoomRepository roomRepository,
			ReservationRepository reservationRepository) {
		this.guestRepository = guestRepository;
		this.roomRepository = roomRepository;
		this.reservationRepository = reservationRepository;
	}

	public List<RoomReservation> getRoomReservationsForDate(String dateString) {
		final var date = !dateString.isEmpty() ? Date.valueOf(dateString) : new Date(new java.util.Date().getTime());

		final var rooms = this.roomRepository.findAll();

		final var roomReservations = rooms.stream().map(room -> {
			final var roomReservation = new RoomReservation();
			roomReservation.setRoomId(room.getId());
			roomReservation.setRoomName(room.getName());
			roomReservation.setRoomNumber(room.getRoomNumber());
			return roomReservation;
		}).collect(Collectors.toMap(RoomReservation::getRoomId, roomReservation -> roomReservation));

		final var reservations = this.reservationRepository.findAllByReservationDate(date);

		reservations.forEach(reservation -> {
			final var roomReservation = roomReservations.get(reservation.getRoomId());
			final var guest = this.guestRepository.findById(reservation.getGuestId()).get();
			roomReservation.setFirstName(guest.getFirstName());
			roomReservation.setLastName(guest.getLastName());
			roomReservation.setGuestId(guest.getId());
			roomReservation.setReservationId(reservation.getId());
		});

		return roomReservations.values().stream().toList();
	}

}
