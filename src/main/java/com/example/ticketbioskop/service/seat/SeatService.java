package com.example.ticketbioskop.service.seat;

import com.example.ticketbioskop.entity.seat.AppSeat;
import org.springframework.stereotype.Service;

@Service
public interface SeatService {

    AppSeat getSeatByStudioAndNumber(String studioName, String seatNumber);
}
