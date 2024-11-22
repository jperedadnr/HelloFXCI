package hellofx;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloFX extends Application {

    public void start(Stage stage) {
        Scene scene = new Scene(new StackPane(new Label("Hi")), 640, 480);
        stage.setScene(scene);
        stage.show();

        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(5));
        pauseTransition.setOnFinished(f -> Platform.exit());
        pauseTransition.play();
    }

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            System.out.println("e = " + e.getMessage());
            e.printStackTrace();
        });
        launch(args);
    }

}
