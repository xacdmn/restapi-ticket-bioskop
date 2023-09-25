package com.example.ticketbioskop.service.seat;

import com.example.ticketbioskop.entity.seat.AppSeat;
import com.example.ticketbioskop.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    SeatRepository seatRepository;

    @Override
    public AppSeat getSeatByStudioAndNumber(String studioName, String seatNumber) {
        return seatRepository.findByStudio_nameAndNomor_kursi(studioName, seatNumber)
                .orElseThrow(() -> new RuntimeException("Seat not found with studioName: " + studioName + " and seatNumber: " + seatNumber));
    }
}
