package com.sayel.bookmyshow_backend.service;

import com.sayel.bookmyshow_backend.entity.Movie;
import com.sayel.bookmyshow_backend.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
    }
    public List<Movie> getAllMovies(){
        return  movieRepository.findAll();
    }
    public Movie getMovieById(Long movieId) {
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
    }


}
