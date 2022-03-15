package hex.entities.components;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import hex.Hex;
import javafx.util.Duration;

/**
 * An entity component to make enemies constantly chase the player
 */
public class EnemyChaseComponent extends Component {
    public EnemyChaseComponent(double speed) {
        FXGL.run(() -> {
            if (getEntity() != null) {
                getEntity().translateTowards(Hex.getPlayer().getPosition(), speed);
            }
        }, Duration.millis(1));
    }

}
