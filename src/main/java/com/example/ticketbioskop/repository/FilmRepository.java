package com.example.ticketbioskop.repository;

import com.example.ticketbioskop.entity.AppFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface FilmRepository extends JpaRepository<AppFilm, String> {

    @Modifying
    @Query(nativeQuery = true, value = "select * from films where sedang_tayang = :showing")
    List<AppFilm> onShow(
            @Param("showing") boolean showing
    );

    AppFilm getAppFilmByFilm_Code(String filmCode);
}
