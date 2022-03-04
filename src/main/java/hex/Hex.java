package hex;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import hex.entities.EntityManager;
import hex.entities.EntityType;
import hex.entities.HexEntityFactory;
import hex.menus.MenuFactory;
import javafx.geometry.Point2D;


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

    @Override
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new HexEntityFactory());

        EntityManager.spawnEntity(EntityType.PLAYER, new Point2D(700, 700));
    }
}
