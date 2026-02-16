package com.sayel.bookmyshow_backend.controller;

import com.sayel.bookmyshow_backend.entity.Movie;
import com.sayel.bookmyshow_backend.repository.MovieRepository;
import com.sayel.bookmyshow_backend.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController( MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public Movie addMovie( @RequestBody Movie movie){
        return movieService.saveMovie(movie);
    }
    @GetMapping
    public List<Movie> getMovie(){
        return movieService.getAllMovies();
    }
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

}
