package me.kallumj.hex;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import me.kallumj.hex.textures.Atlas;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Hex extends ApplicationAdapter {
	private SpriteBatch batch;
	private Atlas atlas;

	@Override
	public void create() {
		batch = new SpriteBatch();
		atlas = new Atlas();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		Sprite sprite = atlas.getSpriteByName("edge");
		sprite.draw(batch);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
}