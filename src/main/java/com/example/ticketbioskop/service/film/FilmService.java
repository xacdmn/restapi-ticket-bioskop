package com.example.ticketbioskop.service.film;

import com.example.ticketbioskop.entity.AppFilm;
import com.example.ticketbioskop.entity.AppSchedule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FilmService {

    AppFilm addFilm(AppFilm film);
    AppFilm updateFilmName(String filmCode, String newName);
    void deleteFilm(String filmCode);
    List<AppFilm> getFilmsInCinema();
    List<AppSchedule> getFilmSchedules(String filmCode);

    AppFilm getFilmByCode(String filmCode);
    AppSchedule getScheduleById(Long scheduleId);

}
