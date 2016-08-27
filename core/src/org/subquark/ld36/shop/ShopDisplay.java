package org.subquark.ld36.shop;

import org.subquark.ld36.InputHandler;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class ShopDisplay {
    private static final Batch batch = new SpriteBatch();
    private static final ShapeRenderer renderer = new ShapeRenderer();
    private static final BitmapFont font = new BitmapFont();
    
    private final InputHandler inputHandler;
    
    public ShopDisplay(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }
    
    public void update() {
        batch.begin();
        font.draw(batch, "Buy Camp", 500, 50);
        font.draw(batch, "Buy Scanner", 500, 150);
        font.draw(batch, "Buy Dig Site", 500, 250);
        font.draw(batch, "Buy Research Station", 500, 350);
        font.draw(batch, "Cancel", 500, 450);
        batch.end();
        
        renderer.begin(ShapeType.Line);
        switch(inputHandler.getSelectedItem()) {
            case Camp:
                renderer.rect(500, 0, 100, 50);
                break;
            case Scanner:
                renderer.rect(500, 100, 100, 50);
                break;
            case DigSite:
                renderer.rect(500, 200, 100, 50);
                break;
            case Research:
                renderer.rect(500, 300, 100, 50);
                break;
            case Nothing:
                break;
            default :
                break;
            
        }
        renderer.end();
    }
}
