package com.example.ticketbioskop.service.film;

import com.example.ticketbioskop.entity.AppFilm;
import com.example.ticketbioskop.entity.AppSchedule;
import com.example.ticketbioskop.repository.FilmRepository;
import com.example.ticketbioskop.repository.ScheduleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService{

    private static final Logger LOGGER = LoggerFactory.getLogger(FilmService.class);

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public AppFilm addFilm(AppFilm film) {
        return filmRepository.save(film);
    }

    @Override
    public AppFilm updateFilmName(String filmCode, String newName) {
        AppFilm film = filmRepository.findById(filmCode).orElseThrow(() -> new IllegalArgumentException("Film not found"));
        film.setFilm_name(newName);
        return filmRepository.save(film);
    }

    @Override
    public void deleteFilm(String filmCode) {
        filmRepository.deleteById(filmCode);
    }

    @Override
    public List<AppFilm> getFilmsInCinema() {
        return filmRepository.onShow(true);
    }

    @Override
    public List<AppSchedule> getFilmSchedules(String filmCode) {
        return scheduleRepository.showScheduleFilm(filmCode);
    }

    @Override
    public AppFilm getFilmByCode(String filmCode) {
        return filmRepository.getAppFilmByFilm_Code(filmCode);
    }

    @Override
    public AppSchedule getScheduleById(Long scheduleId) {
        return scheduleRepository.getAppScheduleBySchedule_id(scheduleId);
    }
}
