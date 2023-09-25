package com.example.ticketbioskop.repository;

import com.example.ticketbioskop.entity.AppSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ScheduleRepository extends JpaRepository<AppSchedule, Long> {

    @Modifying
    @Query(nativeQuery = true, value = "select * from schedules where film_code = :filmCode")
    List<AppSchedule> showScheduleFilm(
            @Param("filmCode") String filmCode
    );

    AppSchedule getAppScheduleBySchedule_id(Long scheduleId);

}
