/**
 * Source: Mastering javafx 10
 * Not recommenable method (Node.setStyle(String style)  method)
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SetStyleDemo extends Application {

    public static void main(String [] args)
    {
        Application.launch(args);

    }

    public void start(Stage primaryStage)
    {
        Application.setUserAgentStylesheet(STYLESHEET_CASPIAN);

        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setHgap(5);
        root.setVgap(5);
        Scene scene = new Scene(root, 300, 250);
        Button btnApply = new Button("apply");
        TextField fontSize, width, height;

        root.addRow(0, new Label("font size"), fontSize = new TextField("30"));
        root.addRow(1, new Label("width"), width = new TextField("100"));
        root.addRow(2, new Label("height"), height = new TextField("80"));


        btnApply.setOnAction(($) ->{

        //instead of CSS setStyle(), you can call a corresponding API method
        //here:  btnApply.setStyle()
        //this is the fastest way in performance-wise to apply a style
        //from java code because javafx doesn't need to spend additional
        //time to parse CSS and style text and then apply the result
        //using API calls.     
            
        btnApply.setStyle(
                "-fx-font-size: " + fontSize.getText() + ";"
                        + "-fx-min-width: " + width.getText() + ";"
                        + "-fx-min-height: " + height.getText());

    });
    root.add(btnApply, 1,3);
    primaryStage.setTitle("setStyle Demo");
    primaryStage.setScene(scene);
    primaryStage.show();
}

}
