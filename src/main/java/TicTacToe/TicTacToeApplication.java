package TicTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {

        Insets insets = new Insets(10);
        BorderPane layout = new BorderPane();

        logicOfGame logic = new logicOfGame();

        layout.setTop(logic.getLabel());
        layout.setCenter(logic.getBoard());
        BorderPane.setMargin(layout, insets);

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();

    }

}
