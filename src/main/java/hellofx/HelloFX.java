package hellofx;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloFX extends Application {

    public void start(Stage stage) {
        final var webView = new WebView();
        webView.getEngine().getLoadWorker().stateProperty().addListener((obs, ov, nv) -> System.out.println("state = " + nv));
        webView.getEngine().getLoadWorker().exceptionProperty().addListener((obs, ov, nv) -> nv.printStackTrace());
        webView.getEngine().load("https://www.bbc.co.uk");
        Scene scene = new Scene(webView, 640, 480);
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