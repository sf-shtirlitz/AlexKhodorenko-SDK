package net.aksdk.movieservice.service;

import net.aksdk.movieservice.dto.APIResponseDto;
import net.aksdk.movieservice.dto.MovieDto;
import net.aksdk.movieservice.entity.Movie;

import java.util.List;

public interface MovieService {
    MovieDto saveMovie(MovieDto movieDto);

    APIResponseDto getMovieById(Long movieId);

    List<Movie> getMovies();
}
