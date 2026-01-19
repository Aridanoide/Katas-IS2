package software.ulpgc.kata2;

import software.ulpgc.kata2.io.RemoteMovieLoader;
import software.ulpgc.kata2.model.Movie;


import java.util.List;

public class Main {
    public static void main(String[] args){
        RemoteMovieLoader loader = new RemoteMovieLoader();
        List<Movie> movies = loader.allMovies();
        for( Movie movie : movies){
            System.out.println(movie);
        }
    }
}
