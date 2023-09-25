package com.example.ticketbioskop.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "films")
@Data
public class AppFilm {

    @Id
    private String film_code;

    private String film_name;
    private boolean sedang_tayang;
}
