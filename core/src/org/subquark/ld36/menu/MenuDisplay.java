package org.subquark.ld36.menu;

import org.subquark.ld36.GameState;
import org.subquark.ld36.Textures;
import org.subquark.ld36.goals.TimeConstraint;
import org.subquark.ld36.goals.TreasureDensity;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class MenuDisplay {
    private static final SpriteBatch batch = new SpriteBatch();
    private static final ShapeRenderer lines = new ShapeRenderer();
    private static final BitmapFont font = new BitmapFont();
    
    private final Textures textures;
    private final GameState gameState;
    private final MenuInputHandler inputHandler;
    
    public MenuDisplay(Textures textures, GameState gameState, MenuInputHandler inputHandler) {
        this.textures = textures;
        this.gameState = gameState;
        this.inputHandler = inputHandler;
    }
    public void update() {
        batch.begin();
        batch.draw(textures.treasurePanel, 50, 180);
        
        if (inputHandler.selectedTreasure == TreasureDensity.LOTS) {
            batch.draw(textures.lottaTreasureButtonSelected, 200, 180);    
        } else {
            batch.draw(textures.lottaTreasureButton, 200, 180);
        }
        if (inputHandler.selectedTreasure == TreasureDensity.SOME) {
            batch.draw(textures.someTreasureButtonSelected, 270, 180);
        } else {
            batch.draw(textures.someTreasureButton, 270, 180);
        }
        
        if (inputHandler.selectedTreasure == TreasureDensity.NONE) {
            batch.draw(textures.littleTreasureButtonSelected, 340, 180);
        } else {
            batch.draw(textures.littleTreasureButton, 340, 180);
        }
        
        batch.draw(textures.timePanel, 50, 120);
        
        if (inputHandler.selectedTime == TimeConstraint.LOTS) {
            batch.draw(textures.lottaTimeButtonSelected, 200, 120);
        } else {
            batch.draw(textures.lottaTimeButton, 200, 120);
        }
        
        if (inputHandler.selectedTime == TimeConstraint.SOME) {
            batch.draw(textures.someTimeButtonSelected, 270, 120);
        } else {
            batch.draw(textures.someTimeButton, 270, 120);
        }
        
        if (inputHandler.selectedTime == TimeConstraint.NONE) {
            batch.draw(textures.littleTimeButtonSelected, 340, 120);
        } else {
            batch.draw(textures.littleTimeButton, 340, 120);
        }
        
        batch.draw(textures.playButton, 270, 60);
        batch.end();
    }
}
