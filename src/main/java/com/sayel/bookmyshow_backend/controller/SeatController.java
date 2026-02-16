package com.sayel.bookmyshow_backend.controller;

import com.sayel.bookmyshow_backend.entity.Seat;
import com.sayel.bookmyshow_backend.entity.SeatStatus;
import com.sayel.bookmyshow_backend.repository.SeatRepository;
import com.sayel.bookmyshow_backend.repository.ShowRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {
    private final SeatRepository seatRepository;
    private final ShowRepository showRepository;

    public SeatController(SeatRepository seatRepository, ShowRepository showRepository) {
        this.seatRepository = seatRepository;
        this.showRepository = showRepository;
    }
    @PostMapping
    public List<Seat> createSeat(@RequestParam Long showId){
        List<Seat> seats = new ArrayList<>();
        for(int i=1; i<=10; i++){
            Seat seat =Seat.builder()
                    .seatNumber("A"+i)
                    .status(SeatStatus.AVAILABLE)
                    .show(showRepository.findById(showId).orElseThrow())
                    .build();
            seats.add(seat);
        }
        return seatRepository.saveAll(seats);
    }
}
