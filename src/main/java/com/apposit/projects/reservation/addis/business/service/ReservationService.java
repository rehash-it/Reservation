package com.apposit.projects.reservation.addis.business.service;

import com.apposit.projects.reservation.addis.business.domain.RoomReservation;
import com.apposit.projects.reservation.addis.data.entity.Guest;
import com.apposit.projects.reservation.addis.data.entity.Reservation;
import com.apposit.projects.reservation.addis.data.entity.Room;
import com.apposit.projects.reservation.addis.data.repository.GuestRepository;
import com.apposit.projects.reservation.addis.data.repository.ReservationRepository;
import com.apposit.projects.reservation.addis.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservationService {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }
    public List<RoomReservation> getRoomReservationForDate(Date date){
        Iterable<Room> rooms=this.roomRepository.findAll();
        Map<Long,RoomReservation>roomReservationMap=new HashMap<>();
        rooms.forEach(room->{
       RoomReservation roomReservation=new RoomReservation();
       roomReservation.setRoomId(room.getId());
       roomReservation.setRoomName(room.getName());
       roomReservation.setRoomNumber(room.getNumber());
       roomReservationMap.put(room.getId(),roomReservation);
        });
        Iterable<Reservation> reservations = this.reservationRepository.findByDate(new java.sql.Date(date.getTime()));
        if(null!=reservations){
            reservations.forEach(reservation -> {
                Guest guest = this.guestRepository.findOne(reservation.getGuestId());
                if(null!=guest){
                    RoomReservation roomReservation = roomReservationMap.get(reservation.getId());
                    roomReservation.setDate(date);
                    roomReservation.setFirstName(guest.getFirstName());
                    roomReservation.setLastName(guest.getLastName());
                    roomReservation.setGuestId(guest.getId());
                }
            });
        }
    List<RoomReservation>roomReservations=new ArrayList<>();
    for(Long roomId:roomReservationMap.keySet()){
        roomReservations.add(roomReservationMap.get(roomId));
    }
return roomReservations;
    }
}
