package hex;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;

public class Hex extends GameApplication {
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(720);
        settings.setHeight(1280);
        settings.setTitle("hex.Hex");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
