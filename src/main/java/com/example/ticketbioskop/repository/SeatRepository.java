package com.example.ticketbioskop.repository;

import com.example.ticketbioskop.entity.seat.AppSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<AppSeat, Long> {

    Optional<AppSeat> findByStudio_nameAndNomor_kursi(String studioName, String seatNumber);

}
