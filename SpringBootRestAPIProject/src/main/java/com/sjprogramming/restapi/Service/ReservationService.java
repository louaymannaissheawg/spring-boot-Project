package com.sjprogramming.restapi.Service;

import com.sjprogramming.restapi.entity.Reservation;
import com.sjprogramming.restapi.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // Create
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // Read
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    // Update
    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found for id: " + id));

        reservation.setAnneeUniversitaire(updatedReservation.getAnneeUniversitaire());
        reservation.setEstValide(updatedReservation.isEstValide());
        reservation.setEtudiants(updatedReservation.getEtudiants());
        reservation.setChambre(updatedReservation.getChambre());

        return reservationRepository.save(reservation);
    }

    // Delete
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
