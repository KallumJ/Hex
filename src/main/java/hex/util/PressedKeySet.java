package hex.util;

import javafx.scene.input.KeyCode;

import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PressedKeySet {
    private final KeyCode[] pressedKeys = new KeyCode[2];

    public void add(KeyCode keyCode) {
        if (pressedKeys[0] == null) {
            pressedKeys[0] = keyCode;
        } else if (pressedKeys[1] == null) {
            pressedKeys[1] = keyCode;
        } else {
            pressedKeys[0] = pressedKeys[1];
            pressedKeys[1] = keyCode;
        }
    }

    public void remove(KeyCode pressedKey) {
        for (int i = 0; i < pressedKeys.length; i++) {
            if (pressedKeys[i] == pressedKey) {
                pressedKeys[i] = null;
            }
        }
    }

    public String toString() {
        return Arrays.toString(pressedKeys);
    }

    public KeyCode getKey1() {
        if (pressedKeys[0] == null && pressedKeys[1] == null) {
            return null;
        } else if (pressedKeys[0] == null) {
            return pressedKeys[1];
        } else {
            return pressedKeys[0];
        }
    }

    public KeyCode getKey2() {
        if (pressedKeys[0] == null && pressedKeys[1] == null) {
            return null;
        } else if (pressedKeys[1] == null) {
            return pressedKeys[0];
        } else {
            return pressedKeys[1];
        }
    }

    public List<KeyCode> getPressedKeys() {
        return Arrays.asList(pressedKeys);
    }
}


