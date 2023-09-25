package com.example.ticketbioskop.entity.seat;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(SeatId.class)
@Table(name = "seats")
@Data
public class AppSeat {

    @Id
    private String studio_name;

    @Id
    private Integer nomor_kursi;
}
