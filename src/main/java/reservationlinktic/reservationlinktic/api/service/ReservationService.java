package reservationlinktic.reservationlinktic.api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reservationlinktic.reservationlinktic.api.exception.ResourceNotFoundException;
import reservationlinktic.reservationlinktic.api.model.Reservation;
import reservationlinktic.reservationlinktic.api.repository.ReservationRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getReservationsByDate(LocalDate date) {
        return reservationRepository.findByReservationDate(date);
    }

    public Reservation updateReservation(Long id, Reservation reservationDetails) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + id));
        reservation.setReservationDate(reservationDetails.getReservationDate());
        reservation.setReservationTime(reservationDetails.getReservationTime());
        reservation.setCustomer(reservationDetails.getCustomer());
        reservation.setService(reservationDetails.getService());
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}