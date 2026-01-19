package software.ulpgc.kata5.application.bee;

import software.ulpgc.kata5.application.Desktop;
import software.ulpgc.kata5.application.RemoteStore;
import software.ulpgc.kata5.application.TsvMovieParser;

public class Main {
    public static void main(String[] args){
        Desktop.create(new RemoteStore(new TsvMovieParser()::from))
                .display()
                .setVisible(true);
    }


}
