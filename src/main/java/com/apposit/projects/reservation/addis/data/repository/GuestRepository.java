package com.apposit.projects.reservation.addis.data.repository;

import com.apposit.projects.reservation.addis.data.entity.Guest;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GuestRepository extends PagingAndSortingRepository<Guest,Long> {

    Guest findOne(long guestId);
}
