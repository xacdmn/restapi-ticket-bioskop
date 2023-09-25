package com.example.ticketbioskop.controller;

import com.example.ticketbioskop.entity.AppFilm;
import com.example.ticketbioskop.entity.AppSchedule;
import com.example.ticketbioskop.service.film.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @PostMapping("/film/add")
    public ResponseEntity<AppFilm> addFilm(@RequestBody AppFilm film) {
        return ResponseEntity.ok(filmService.addFilm(film));
    }

    @PutMapping("/film/{filmCode}")
    public ResponseEntity<AppFilm> updateFilmName(@PathVariable String filmCode, @RequestBody AppFilm film) {
        return ResponseEntity.ok(filmService.updateFilmName(filmCode, film.getFilm_name()));
    }

    @DeleteMapping("/film/{filmCode}")
    public ResponseEntity<Void> deleteFilm(@PathVariable String filmCode) {
        filmService.deleteFilm(filmCode);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/film/in-cinema")
    public ResponseEntity<List<AppFilm>> getFilmsInCinema() {
        return ResponseEntity.ok(filmService.getFilmsInCinema());
    }

    @PostMapping("/film/{filmCode}/schedules")
    public ResponseEntity<List<AppSchedule>> getFilmSchedules(@PathVariable String filmCode) {
        return ResponseEntity.ok(filmService.getFilmSchedules(filmCode));
    }
}
