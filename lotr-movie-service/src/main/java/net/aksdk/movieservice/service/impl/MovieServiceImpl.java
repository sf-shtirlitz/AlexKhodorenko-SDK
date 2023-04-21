package net.aksdk.movieservice.service.impl;

import lombok.AllArgsConstructor;
import net.aksdk.movieservice.dto.APIResponseDto;
import net.aksdk.movieservice.dto.MovieDto;
import net.aksdk.movieservice.entity.Movie;
import net.aksdk.movieservice.mapper.MovieMapper;
import net.aksdk.movieservice.repository.MovieRepository;
import net.aksdk.movieservice.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);

    private MovieRepository movieRepository;

    @Override
    public MovieDto saveMovie(MovieDto movieDto) {

        Movie movie = MovieMapper.mapToMovie(movieDto);

        Movie savedMovie = movieRepository.save(movie);

        MovieDto savedMovieDto = MovieMapper.mapToMovieDto(savedMovie);

        return savedMovieDto;
    }

    //@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    //@Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getMovieById(Long movieId) {

        LOGGER.info("inside getMovieById() method");
        Movie movie = movieRepository.findById(movieId).get();

        MovieDto movieDto = MovieMapper.mapToMovieDto(movie);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setMovie(movieDto);
        return apiResponseDto;
    }

    public List<Movie> getMovies() {
        LOGGER.info("inside getMovies() method");

        List<Movie> movieList = movieRepository.findAll();

        return movieList;
    }
}
