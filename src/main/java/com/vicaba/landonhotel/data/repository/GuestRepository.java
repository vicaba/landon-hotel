package com.vicaba.landonhotel.data.repository;

import com.vicaba.landonhotel.data.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}
