package TicTacToe;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class logicOfGame {

    private GridPane board;
    private String turn;
    private Label move;
    private String[][] winMove;
    int order;

    public logicOfGame() {
        this.board = new GridPane();
        this.turn = "X";
        this.move = new Label("Turn: " + this.turn);
        this.setSettings();
        this.winMove = new String[3][3];
        this.order = 0;

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                this.winMove[x][y] = "z";
            }
        }

    }

    public GridPane getBoard() {
        return this.board;
    }

    private void setSettings() {
        this.board.setHgap(10);
        this.board.setVgap(10);
        this.board.setPrefSize(340, 340);
        this.board.setAlignment(Pos.CENTER);
        this.move.setFont(Font.font("Monospaced", 40));

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Button button = new Button();
                button.setFont(Font.font("Monospaced", 40));
                button.setPrefSize(100, 100);
                setRules(button);
                this.board.add(button, y, x);
                button.setId(x + " " + y);
            }
        }
    }

    public String getTurn() {
        return this.turn;
    }

    private void setRules(Button buttonGame) {
        buttonGame.setOnAction((event) -> {
            if (buttonGame.getText().isEmpty()) {
                buttonGame.setText(this.turn);
                order++;
                splitting(buttonGame, this.turn);
                changeTurn();
                this.move.setText("Turn: " + this.turn);
                if (checking()) {
                    this.board.setDisable(true);
                }
            }
        });

    }

    private void changeTurn() {
        if (this.turn.contains("X")) {
            this.turn = "O";
        } else {
            this.turn = "X";
        }
    }

    public Label getLabel() {
        return this.move;
    }

    private void splitting(Button button, String id) {
        String[] cord = button.getId().split(" ");
        button.setId(id);
        this.winMove[Integer.valueOf(cord[0])][Integer.valueOf(cord[1])] = id;
    }

    private boolean checking() {
        for (int y = 0; y < 3; y++) {
            if ((this.winMove[0][y].contains("X") && this.winMove[1][y].contains("X") && this.winMove[2][y].contains("X")) || (this.winMove[y][0].contains("X") && this.winMove[y][1].contains("X") && this.winMove[y][2].contains("X")) || (this.winMove[0][y].contains("O") && this.winMove[1][y].contains("O") && this.winMove[2][y].contains("O")) || (this.winMove[y][0].contains("O") && this.winMove[y][1].contains("O") && this.winMove[y][2].contains("O"))) {
                this.move.setText("The end!");
                return true;
            }
        }
        if ((this.winMove[0][0].contains("X") && this.winMove[1][1].contains("X") && this.winMove[2][2].contains("X")) || (this.winMove[0][0].contains("O") && this.winMove[1][1].contains("O") && this.winMove[2][2].contains("O"))) {
            this.move.setText("The end!");
            return true;
        }

        if ((this.winMove[0][2].contains("X") && this.winMove[1][1].contains("X") && this.winMove[2][0].contains("X")) || (this.winMove[0][2].contains("O") && this.winMove[1][1].contains("O") && this.winMove[2][0].contains("O"))) {
            this.move.setText("The end!");
            return true;
        }
        if (order > 8) {
            this.move.setText("The end!");
            return true;
        }
        return false;
    }

}
