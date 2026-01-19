package software.ulpgc.kata6.application.bee;

import software.ulpgc.kata6.application.Desktop;
import software.ulpgc.kata6.application.RemoteStore;
import software.ulpgc.kata6.application.TsvMovieParser;

public class Main {
    public static void main(String[] args){
        Desktop.create(new RemoteStore(new TsvMovieParser()::from))
                .display()
                .setVisible(true);
    }


}
