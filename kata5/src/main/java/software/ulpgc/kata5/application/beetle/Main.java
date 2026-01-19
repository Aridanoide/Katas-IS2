package software.ulpgc.kata5.application.beetle;

import software.ulpgc.kata5.application.*;
import software.ulpgc.kata5.architecture.model.Movie;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:movies.db")) {
            connection.setAutoCommit(false);
            importIfNeededInto(connection);
            Desktop.create(new DatabaseStore(connection))
                    .display()
                    .setVisible(true);
        }
    }

    private static void importIfNeededInto(Connection connection) throws SQLException {
        if (new File("movies.db").length() > 0) return;
        Stream<Movie> movies = new RemoteStore(new TsvMovieParser()::from)
                .movies()
                .filter(movie -> movie.year() > 1900)
                .filter(movie -> movie.year() < 2025);

        new DatabaseRecorder(connection).record(movies);
    }
}
