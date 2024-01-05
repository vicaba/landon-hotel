package com.vicaba.landonhotel.data.repository;

import com.vicaba.landonhotel.data.entity.Room;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

	Optional<Room> findByRoomNumberIgnoreCase(String roomNumber);

}
