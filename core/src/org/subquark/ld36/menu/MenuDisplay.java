package org.subquark.ld36.menu;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class MenuDisplay {
    private static final SpriteBatch batch = new SpriteBatch();
    private static final ShapeRenderer lines = new ShapeRenderer();
    private static final BitmapFont font = new BitmapFont();
    
    public void update() {
        lines.begin(ShapeType.Line);
        lines.rect(130 + 10, 210 + 10, 90, 40);
        lines.rect(230 + 10, 210 + 10, 90, 40);
        lines.rect(330 + 10, 210 + 10, 90, 40);

        lines.rect(130 + 10, 260 + 10, 90, 40);
        lines.rect(230 + 10, 260 + 10, 90, 40);
        lines.rect(330 + 10, 260 + 10, 90, 40);

        lines.rect(130 + 10, 310 + 10, 90, 40);
        lines.rect(230 + 10, 310 + 10, 90, 40);
        lines.rect(330 + 10, 310 + 10, 90, 40);
        lines.end();
        
        batch.begin();
        font.draw(batch, "Egypt Excavation", 0, 450);
        
        font.draw(batch, "Much Time", 150, 400);
        font.draw(batch, "Some Time", 250, 400);
        font.draw(batch, "Little Time", 350, 400);
        
        font.draw(batch, "Lots of Treasure", 0, 350);
        font.draw(batch, "Some Treasure", 0, 300);
        font.draw(batch, "Almost no Treasure", 0, 250);
        
        font.draw(batch, "Dig!", 170, 250);
        font.draw(batch, "Dig!", 270, 250);
        font.draw(batch, "Dig!", 370, 250);
        
        font.draw(batch, "Dig!", 170, 300);
        font.draw(batch, "Dig!", 270, 300);
        font.draw(batch, "Dig!", 370, 300);
        
        font.draw(batch, "Dig!", 170, 350);
        font.draw(batch, "Dig!", 270, 350);
        font.draw(batch, "Dig!", 370, 350);
        batch.end();
    }
}
