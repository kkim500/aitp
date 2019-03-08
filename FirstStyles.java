/**
 * Source:  Mastering JavaFX 10 by Sergey Grinev
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FirstStyles extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        Scene scene = new Scene(root, 300, 250);


        Button btnLoad = new Button("Load CSS");
        btnLoad.setId("my-style");
        btnLoad.setOnAction((ActionEvent event) -> {


            scene.getStylesheets().add(getClass().getResource("FirstStyles.css").toExternalForm());
           //  scene.getStylesheets().add(FirstStyles.class.getResource("FirstStyles.css").toExternalForm());
            //
        });

        Button btnUnload = new Button("Unload CSS");
        btnUnload.setOnAction((ActionEvent event) -> {
            scene.getStylesheets().clear();
        });

        root.getChildren().addAll(btnLoad, btnUnload);
        stage.setTitle("Hello CSS!");
        stage.setScene(scene);
        stage.show();
    }

}