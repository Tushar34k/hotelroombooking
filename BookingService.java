package com.booking.system.bookingservice;

import java.util.List;

import com.booking.system.entity.Booking;

public interface BookingService {
	
	Booking bookingService(Booking booking);
	
	List<Booking> checkAvailableRoom(String roomTypes);
	
	Booking cancalBooking(Long id);

}
