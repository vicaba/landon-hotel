package com.vicaba.landonhotel.web.controller;

import com.vicaba.landonhotel.data.repository.RoomRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rooms")
public class RoomController {

	private final RoomRepository roomRepository;

	public RoomController(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

	@GetMapping
	public String getAllRooms(Model model) {
		model.addAttribute("rooms", this.roomRepository.findAll());
		return "room-list";
	}

}
