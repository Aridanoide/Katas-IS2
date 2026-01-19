package software.ulpgc.kata2.serializers;

import software.ulpgc.kata2.model.Movie;

public interface MovieParser {
    public Movie from(String line);
}
