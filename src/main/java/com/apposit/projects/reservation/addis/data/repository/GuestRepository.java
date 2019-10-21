package com.apposit.projects.reservation.addis.data.repository;

import com.apposit.projects.reservation.addis.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {


    @Override
    Optional<Guest> findById(Long id);

    Guest getOne(Long id);
}