package hex.menus.controllers;

import com.almasb.fxgl.dsl.FXGL;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

/**
 * A method to control the Main Menu for Hex
 */
public class MainMenuController {
    @FXML
    private VBox mainMenuVBox;

    @FXML
    private void playButtonClicked() {
        FXGL.getGameController().startNewGame();
    }

    @FXML
    private void exitButtonClicked() {
        FXGL.getGameController().exit();
    }

    @FXML
    protected void initialize() {
        mainMenuVBox.setPrefWidth(FXGL.getAppWidth());
        mainMenuVBox.setPrefHeight(FXGL.getAppHeight());
    }
}
