package me.kallumj.hex.textures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Atlas {
    private final TextureAtlas textureAtlas;

    public Atlas() {
        this.textureAtlas = new TextureAtlas("sprites.txt");
    }

    public Sprite getSpriteByName(String name) {
       return textureAtlas.createSprite(name);
    }
}
