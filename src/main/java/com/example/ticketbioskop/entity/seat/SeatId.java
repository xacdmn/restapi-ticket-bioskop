package com.example.ticketbioskop.entity.seat;

import lombok.Data;

import java.io.Serializable;

@Data
public class SeatId implements Serializable {

    private String studio_name;
    private Integer nomor_kursi;

}
