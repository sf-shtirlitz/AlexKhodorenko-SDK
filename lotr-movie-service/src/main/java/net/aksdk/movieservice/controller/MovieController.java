package net.aksdk.movieservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.aksdk.movieservice.dto.APIResponseDto;
import net.aksdk.movieservice.dto.MovieDto;
import net.aksdk.movieservice.dto.QuoteDto;
import net.aksdk.movieservice.entity.Movie;
import net.aksdk.movieservice.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Movie Service - MovieController",
        description = "Movie Controller Exposes REST APIs for Movie-Service"
)
@RestController
@RequestMapping("movie")
@AllArgsConstructor
public class MovieController {

    private MovieService movieService;

    // Build Save Movie REST API
    @Operation(
            summary = "Save Movie REST API",
            description = "Save Movie REST API is used to save Movie object in DB"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<MovieDto> saveMovie(@RequestBody MovieDto movieDto){
        MovieDto savedMovie = movieService.saveMovie(movieDto);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }

    // Build Get Movie REST API
    @Operation(
            summary = "Get Movie REST API",
            description = "Get Movie REST API is used to get Movie object from the DB"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getMovie(@PathVariable("id") Long movieId){
        APIResponseDto apiResponseDto = movieService.getMovieById(movieId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }

    @GetMapping()
    public List<Movie> getMovies(){
        return movieService.getMovies();
    }

    @GetMapping("{id}/quote")
    public ResponseEntity<String> getQuote(@PathVariable("id") Long movieId){
        APIResponseDto apiResponseDto = movieService.getMovieById(movieId);
        return new ResponseEntity<>(apiResponseDto.getMovie().getMovieQuote(), HttpStatus.OK);
    }
}
