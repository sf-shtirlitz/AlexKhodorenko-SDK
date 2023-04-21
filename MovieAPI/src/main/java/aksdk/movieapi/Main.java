package aksdk.movieapi;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        MovieAPI api = new MovieAPI("http://localhost:9191");
        List<String> movies = api.getMovieList();
        System.out.println("Movie list:");
        for(String movie : movies) {
            System.out.println(movie);
        }

        int movieId = 1;
        String movie = api.getMovieById(movieId);
        System.out.println("Movie with ID " + movieId + ": " + movie);

        List<String> quotes = api.getMovieQuotesById(movieId);
        System.out.println("Quotes for movie with ID " + movieId + ":");
        for(String quote : quotes) {
            System.out.println(quote);
        }
    }
}