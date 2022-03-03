package hex.menus;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.SceneFactory;
import org.jetbrains.annotations.NotNull;

/**
 * A class to provide scenes to FXGL
 */
public class MenuFactory extends SceneFactory {
    @NotNull
    @Override
    public FXGLMenu newMainMenu() {
        return new MainMenu();
    }
}
