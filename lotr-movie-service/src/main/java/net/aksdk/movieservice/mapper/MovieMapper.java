package net.aksdk.movieservice.mapper;

import net.aksdk.movieservice.dto.MovieDto;
import net.aksdk.movieservice.entity.Movie;

public class MovieMapper {

    public static MovieDto mapToMovieDto(Movie movie){
        MovieDto movieDto = new MovieDto(
                movie.getId(),
                movie.getMovieName(),
                movie.getMovieQuote()
        );
        return movieDto;
    }

    public static Movie mapToMovie(MovieDto movieDto){
        Movie movie = new Movie(
                movieDto.getId(),
                movieDto.getMovieName(),
                movieDto.getMovieQuote()
        );
        return movie;
    }
}
