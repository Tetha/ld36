package org.subquark.ld36.shop;

import org.subquark.ld36.InputHandler;
import org.subquark.ld36.InputHandler.SelectedItem;
import org.subquark.ld36.Textures;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ShopDisplay {
    private static final Batch batch = new SpriteBatch();
    
    private final InputHandler inputHandler;
    private final Textures textures;
    
    public ShopDisplay(Textures textures, InputHandler inputHandler) {
        this.inputHandler = inputHandler;
        this.textures = textures;
    }
    
    public void update() {
        batch.begin();
        if (inputHandler.getSelectedItem() == SelectedItem.Camp) {
            batch.draw(textures.campBuyButtonSelected, 500, 350);
        } else {
            batch.draw(textures.campBuyButton, 500, 350);
        }
        batch.draw(textures.camp, 510, 355);
        
        if (inputHandler.getSelectedItem() == SelectedItem.Scanner) {
            batch.draw(textures.prospectorBuyButtonSelected, 500, 300);
        } else {
            batch.draw(textures.prospectorBuyButton, 500, 300);
        }
        batch.draw(textures.scanner, 510, 305);
        
        if (inputHandler.getSelectedItem() == SelectedItem.DigSite) {
            batch.draw(textures.diggerBuyButtonSelected, 500, 250);
        } else {
            batch.draw(textures.diggerBuyButton, 500, 250);
        }
        batch.draw(textures.digger, 510, 255);

        if (inputHandler.getSelectedItem() == SelectedItem.Research) {
            batch.draw(textures.researchBuyButtonSelected, 500, 200);
        } else {
            batch.draw(textures.researchBuyButton, 500, 200);
        }
        batch.draw(textures.research, 510, 205);
        batch.end();
    }
}
