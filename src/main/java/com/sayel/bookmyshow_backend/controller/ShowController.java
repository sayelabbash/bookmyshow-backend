package com.sayel.bookmyshow_backend.controller;

import com.sayel.bookmyshow_backend.entity.Show;
import com.sayel.bookmyshow_backend.repository.MovieRepository;
import com.sayel.bookmyshow_backend.repository.ShowRepository;
import com.sayel.bookmyshow_backend.repository.TheatreRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shows")
public class ShowController {
    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final TheatreRepository theatreRepository;

    public ShowController(ShowRepository showRepository, MovieRepository movieRepository, TheatreRepository theatreRepository) {
        this.showRepository = showRepository;
        this.movieRepository = movieRepository;
        this.theatreRepository = theatreRepository;
    }
    @PostMapping
    public Show createShow(@RequestParam Long movieId,
                           @RequestParam Long theatreId,
                           @RequestBody Show show){
        show.setMovie(movieRepository.findById(movieId).orElseThrow());
        show.setTheatre(theatreRepository.findById(theatreId).orElseThrow());
        return showRepository.save(show);
    }

}
