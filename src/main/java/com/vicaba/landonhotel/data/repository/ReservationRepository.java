package com.vicaba.landonhotel.data.repository;

import com.vicaba.landonhotel.data.entity.Reservation;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	List<Reservation> findAllByReservationDate(Date date);

}
