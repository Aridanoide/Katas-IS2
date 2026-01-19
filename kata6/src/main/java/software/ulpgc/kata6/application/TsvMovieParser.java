package software.ulpgc.kata6.application;

import software.ulpgc.kata6.architecture.model.Movie;
import software.ulpgc.kata6.architecture.serializers.MovieParser;

public class TsvMovieParser implements MovieParser {
    @Override
    public Movie from(String line){
        return from(line.split("\t"));
    }

    private Movie from(String[] split) {
        return new Movie(split[2], toInt(split[5]), toInt(split[7]));
    }

    private int toInt(String s) {
        if(isVoid(s)) return -1;
        return Integer.parseInt(s);
    }

    private boolean isVoid(String s) {
        return s.equals("\\N");
    }
}
