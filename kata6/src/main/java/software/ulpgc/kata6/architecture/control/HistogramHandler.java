package software.ulpgc.kata6.architecture.control;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import software.ulpgc.kata6.architecture.io.Store;
import software.ulpgc.kata6.architecture.model.Movie;
import software.ulpgc.kata6.architecture.viewmodel.Histogram;
import software.ulpgc.kata6.architecture.viewmodel.HistogramBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class HistogramHandler implements Handler {
    private final Store store;

    public HistogramHandler(Store store) {
        this.store = store;
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        String fromParam = context.queryParam("from");
        String toParam = context.queryParam("to");

        Stream<Movie> movies = store.movies();

        if (fromParam != null){
            int from = Integer.parseInt(fromParam);
            movies = movies.filter(m->m.year() >= from);
        }
        if (toParam != null){
            int to = Integer.parseInt(fromParam);
            movies = movies.filter(m->m.year() >= to);
        }

        Histogram histogram = HistogramBuilder.with(movies).use(Movie::year);
        Map<String, Integer> jsonResult = new HashMap<>();
        for(Integer bin: histogram){
            jsonResult.put(String.valueOf(bin), histogram.count(bin));
        }


        context.json(jsonResult);
    }
}
