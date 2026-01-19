package software.ulpgc.kata6.architecture.viewmodel;

import software.ulpgc.kata6.architecture.model.Movie;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public class HistogramBuilder {
    private final Stream<Movie> movies;
    private final Map<String, String> labels;

    public static HistogramBuilder with(Stream<Movie> movies){
        if(movies == null)throw new IllegalArgumentException("movies cannot be null");
        return new HistogramBuilder(movies);
    }

    public HistogramBuilder(Stream<Movie> movies) {
        this.movies = movies;
        this.labels = new HashMap<>();
    }

    public HistogramBuilder title(String label){
        labels.put("title", label);
        return this;
    }

    public HistogramBuilder x(String label){
        labels.put("x", label);
        return this;
    }

    public HistogramBuilder y(String label){
        labels.put("y", label);
        return this;
    }

    public HistogramBuilder legend(String label){
        labels.put("legend", label);
        return this;
    }

    public Histogram use(Function<Movie, Integer> function){
        Histogram histogram = new Histogram(labels);
        movies.map(function).forEach(histogram::add);
        return histogram;
    }
}