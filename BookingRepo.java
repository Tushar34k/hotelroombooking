package com.booking.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.system.entity.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long> {

    List<Booking> findByRoomTypeAndIsCancelledFalse(String roomType);

}
