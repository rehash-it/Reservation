package com.apposit.projects.reservation.addis.data.repository;

import com.apposit.projects.reservation.addis.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation,Long> {
}
