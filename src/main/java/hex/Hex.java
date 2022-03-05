package hex;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import hex.entities.EnemyFactory;
import hex.entities.EntityManager;
import hex.entities.EntityType;
import hex.entities.PlayerFactory;
import hex.menus.MenuFactory;
import javafx.geometry.Point2D;


public class Hex extends GameApplication {
    public static final int HEIGHT = 1280;
    public static final int WIDTH = 1920;
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
        FXGL.setLevelFromMap("map.tmx");

        FXGL.getGameWorld().addEntityFactory(new PlayerFactory());
        FXGL.getGameWorld().addEntityFactory(new EnemyFactory());

        EntityManager.spawnEntity(EntityType.PLAYER, new Point2D(700, 700));

        WaveManager waveManager = new WaveManager();
        waveManager.generateWave();
    }
}
