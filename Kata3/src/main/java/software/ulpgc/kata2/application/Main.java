package software.ulpgc.kata2.application;

import software.ulpgc.kata2.model.Movie;
import software.ulpgc.kata2.viewmodel.Histogram;
import software.ulpgc.kata2.viewmodel.HistogramBuilder;


import java.util.List;

public class Main {
    public static void main(String[] args){
        RemoteMovieLoader loader = new RemoteMovieLoader();
        List<Movie> movies = loader.allMovies();
        Histogram histogram = new HistogramBuilder(m->(m.year() / 10) * 10).buildWith(movies);
        for( int d : histogram){
            System.out.println(d + ": " + histogram.count(d));
        }
    }
}
