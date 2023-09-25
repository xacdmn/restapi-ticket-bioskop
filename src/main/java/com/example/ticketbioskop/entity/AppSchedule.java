package com.example.ticketbioskop.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "schedules")
@Data
public class AppSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schedule_id;

    @ManyToOne
    @JoinColumn(name = "film_code")
    private AppFilm film;

    private Date tanggal_tayang;
    private Time jam_mulai;
    private Time jam_selesai;
    private BigDecimal harga_ticket;

}
