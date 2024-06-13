package com.booking.system.bookingcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.system.bookingservice.BookingService;
import com.booking.system.entity.Booking;

@RestController

@RequestMapping("/hotel")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping("/booking")
	public ResponseEntity<Booking> roomBooking(@RequestBody Booking booking) {
		Booking booking2 = bookingService.bookingService(booking);

		return new ResponseEntity<>(booking2, HttpStatus.CREATED);
	}

	
	@GetMapping("/checkavailableroom")
	public ResponseEntity<List<Booking>> checkAvailableRooms(@RequestParam String roomsType)
	{
		        List<Booking> bookings=bookingService.checkAvailableRoom(roomsType);
		                                
		                    return new ResponseEntity<>(bookings,HttpStatus.OK);
	}
	
	
	 @PutMapping("/cancel/{id}")
	    public ResponseEntity<Booking> cancelBooking(@PathVariable Long id) {
	        try {
	            Booking cancelledBooking = bookingService.cancalBooking(id);
	            return new ResponseEntity<>(cancelledBooking, HttpStatus.OK);
	        } catch (RuntimeException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	
	


	 }
}
