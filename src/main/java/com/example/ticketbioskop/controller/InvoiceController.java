package com.example.ticketbioskop.controller;

import com.example.ticketbioskop.entity.*;
import com.example.ticketbioskop.entity.seat.AppSeat;
import com.example.ticketbioskop.entity.seat.InvoiceRequest;
import com.example.ticketbioskop.entity.user.AppUser;
import com.example.ticketbioskop.service.film.FilmService;
import com.example.ticketbioskop.service.invoice.InvoiceService;
import com.example.ticketbioskop.service.seat.SeatService;
import com.example.ticketbioskop.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private FilmService filmService;

    @Autowired
    private UserService userService;

    @Autowired
    private SeatService seatService;

    @PostMapping("/invoice")
    public ResponseEntity<byte[]> generateInvoice(@RequestBody InvoiceRequest request) {
        AppUser user = userService.getUserById(request.getUserId());
        AppFilm film = filmService.getFilmByCode(request.getFilmCode());
        AppSchedule schedule = filmService.getScheduleById(request.getScheduleId());
        AppSeat seat = seatService.getSeatByStudioAndNumber(request.getStudioName(), request.getSeatNumber());

        byte[] invoice = invoiceService.generateInvoice(user, seat, film, schedule);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("inline").filename("invoice.pdf").build());

        return new ResponseEntity<>(invoice, headers, HttpStatus.OK);
    }
}

