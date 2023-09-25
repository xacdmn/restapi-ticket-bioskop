package com.example.ticketbioskop.service.invoice;

import com.example.ticketbioskop.entity.AppFilm;
import com.example.ticketbioskop.entity.AppSchedule;
import com.example.ticketbioskop.entity.seat.AppSeat;
import com.example.ticketbioskop.entity.user.AppUser;
import org.springframework.stereotype.Service;

@Service
public interface InvoiceService {

    byte[] generateInvoice(AppUser user, AppSeat seat, AppFilm film, AppSchedule schedule);
}
