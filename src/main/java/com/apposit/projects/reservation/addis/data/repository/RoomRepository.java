package com.apposit.projects.reservation.addis.data.repository;

import com.apposit.projects.reservation.addis.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{
    Room findByNumber(String number);
}