package software.ulpgc.kata5.architecture.serializers;

import software.ulpgc.kata5.architecture.model.Movie;

public interface MovieParser {
    public Movie from(String line);
}
