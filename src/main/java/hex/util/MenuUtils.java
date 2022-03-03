package hex.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;

/**
 * A utility class for manipulating and creating menus
 */
public class MenuUtils {
    private static final String FXML_PATH = "layouts/";
    private final static String LOAD_ERR = "Failed to load %s";

    /**
     * Gets the URL of the provided FXML file
     * @param path the name of the fxml file in the FXML_PATH dir
     * @return the URL of the found file
     */
    private static URL getFXMLResource(String path) {
        return ResourceUtils.getResource(FXML_PATH + path);
    }

    /**
     * Load the provided FXML file
     * @param fxml the name of the fxml file in the FXML_PATH dir
     * @return the loaded FXML content
     */
    public static Node loadFXML(String fxml) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getFXMLResource(fxml));
            return fxmlLoader.<Pane>load();
        } catch (IOException ex) {
            throw new RuntimeException(LOAD_ERR, ex);
        }
    }
}
