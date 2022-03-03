package hex;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import hex.menus.MenuFactory;

public class Hex extends GameApplication {
    private static final int HEIGHT = 1080;
    private static final int WIDTH = 1920;
    private static final String TITLE = "Hex";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(WIDTH);
        settings.setHeight(HEIGHT);
        settings.setTitle(TITLE);
        settings.setMainMenuEnabled(true);

        settings.setSceneFactory(new MenuFactory());
    }
}
