package com.apposit.projects.reservation.addis.data.repository;

import com.apposit.projects.reservation.addis.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation,Long> {
    List<Reservation> findByDate(Date date);
}
