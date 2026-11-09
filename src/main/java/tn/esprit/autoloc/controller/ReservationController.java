package tn.esprit.autoloc.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final IReservationService reservationService;

    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.ajouterReservation(reservation);
    }

    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationService.modifierReservation(reservation);
    }

    @GetMapping("/getAllReservation")
    public List<Reservation> getAllReservations() {
        return reservationService.afficherAllReservation();
    }

    @GetMapping("/getReservation/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.afficherReservationById(id);
    }

    @DeleteMapping("/deleteReservation/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.supprimerReservation(id);
    }
}
