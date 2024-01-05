package com.vicaba.landonhotel.web;

import com.vicaba.landonhotel.data.entity.Room;
import com.vicaba.landonhotel.data.repository.RoomRepository;
import com.vicaba.landonhotel.web.exception.NotFoundException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rooms")
public class RoomApiController {

	private final RoomRepository roomRepository;

	public RoomApiController(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

	@GetMapping
	public List<Room> getAllRooms() {
		return this.roomRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createRoom(@RequestBody Room room) {
		this.roomRepository.save(room);
	}

	@GetMapping("/id")
	public Room getRoomById(@PathVariable(name = "id") long id) {
		return this.roomRepository.findById(id)
			.orElseThrow(() -> new NotFoundException("Room not found with id: " + id));
	}

	@PutMapping("/id")
	public Room updateRoom(@PathVariable(name = "id") long id, @RequestBody Room room) {
		return this.roomRepository.save(room);
	}

	@DeleteMapping("/id")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteRoom(@PathVariable(name = "id") long id) {
		this.roomRepository.deleteById(id);
	}

}
