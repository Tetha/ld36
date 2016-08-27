package org.subquark.ld36.camp;

import org.subquark.ld36.GameState;
import org.subquark.ld36.Textures;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CampDisplay {
    //private static final ShapeRenderer renderer = new ShapeRenderer();
    private final SpriteBatch batch = new SpriteBatch();
    
    private final Textures textures;
    private final GameState gameState;
    
    public CampDisplay(Textures textures, GameState gameState) {
        this.textures = textures;
        this.gameState = gameState;
    }
    
    /*
    public void update() {
        renderer.begin(ShapeType.Filled);
        renderer.setColor(Color.RED);
        for (Camp c : gameState.camps) {
            renderer.rect(c.x - Camp.CAMP_WIDTH/2, c.y - Camp.CAMP_HEIGHT / 2, Camp.CAMP_WIDTH, Camp.CAMP_HEIGHT);
        }
        renderer.end();
    }*/
    
    public void update() {
        batch.begin();
        for (Camp c : gameState.camps) {
            batch.draw(textures.camp, c.x - Camp.CAMP_WIDTH/2, c.y - Camp.CAMP_HEIGHT / 2);
        }
        batch.end();
    }
}
