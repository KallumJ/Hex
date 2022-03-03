package hex.menus;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import hex.util.MenuUtils;

/**
 * A class to model the Main Menu for Hex
 *
 * @author KallumJ
 */
public class MainMenu extends FXGLMenu {
    private static final String FXML_PATH = "mainMenu.fxml";

    public MainMenu() {
        super(MenuType.MAIN_MENU);

        getContentRoot().getChildren().addAll(
                MenuUtils.loadFXML(FXML_PATH)
        );
    }
}
