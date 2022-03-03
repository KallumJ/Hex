package hex.util;

import hex.Hex;

import java.net.URL;

/**
 * A class for manipulating files in the resources folder
 */
public class ResourceUtils {

    /**
     * Gets the file in the resources dir as a URL
     * @param path the path in the resources dir
     * @return the URL in the resources dir of the provided file
     */
    public static URL getResource(String path) {
        return Hex.class.getClassLoader().getResource(path);
    }
}
