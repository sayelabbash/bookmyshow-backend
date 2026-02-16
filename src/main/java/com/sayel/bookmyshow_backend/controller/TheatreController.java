package com.sayel.bookmyshow_backend.controller;

import com.sayel.bookmyshow_backend.entity.Theatre;
import com.sayel.bookmyshow_backend.repository.TheatreRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theatres")
public class TheatreController {
    private final TheatreRepository theatreRepository;

    public TheatreController(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }
    @PostMapping
    public Theatre createTheatre(@RequestBody Theatre theatre){
        return theatreRepository.save(theatre);
    }

}
