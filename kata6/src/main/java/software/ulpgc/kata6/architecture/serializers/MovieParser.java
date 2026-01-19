package software.ulpgc.kata6.architecture.serializers;

import software.ulpgc.kata6.architecture.model.Movie;

public interface MovieParser {
    public Movie from(String line);
}
