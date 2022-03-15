package hex;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.physics.PhysicsWorld;
import hex.entities.EnemyType;
import hex.entities.EntityType;
import hex.entities.WaveManager;
import hex.entities.collisions.FireballEnemyCollider;
import hex.entities.goblin.GoblinFactory;
import hex.entities.player.PlayerFactory;
import hex.entities.player.PlayerWrapper;
import hex.entities.spells.fireball.FireballFactory;
import hex.entities.spells.windstorm.WindstormFactory;
import hex.menus.MenuFactory;
import javafx.geometry.Point2D;
import javafx.scene.text.Text;


public class Hex extends GameApplication {
    public static final int HEIGHT = 1080;
    public static final int WIDTH = 1920;
    public static final WaveManager WAVE_MANAGER = new WaveManager();
    private static final String TITLE = "Hex";
    private static PlayerWrapper player;

    public static void main(String[] args) {
        launch(args);
    }

    public static PlayerWrapper getPlayer() {
        return player;
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
    protected void initPhysics() {
        PhysicsWorld physicsWorld = FXGL.getPhysicsWorld();

        for (EnemyType enemyType : EnemyType.values()) {
            physicsWorld.addCollisionHandler(new FireballEnemyCollider(enemyType));
        }

    }

    @Override
    protected void initUI() {
        Text text = WAVE_MANAGER.getCurrentWaveText();
        FXGL.getGameScene().addUINode(text);

        FXGL.getGameScene().addUINode(player.getSpellInventoryNode());
    }


    @Override
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new PlayerFactory());
        FXGL.getGameWorld().addEntityFactory(new GoblinFactory());
        FXGL.getGameWorld().addEntityFactory(new FireballFactory());
        FXGL.getGameWorld().addEntityFactory(new WindstormFactory());

        FXGL.setLevelFromMap("map.tmx");

        FXGL.spawn(EntityType.PLAYER.toString(), new Point2D(700, 700));

        player = new PlayerWrapper(FXGL.getGameWorld().getSingleton(EntityType.PLAYER));

        WAVE_MANAGER.generateWave();
    }
}
