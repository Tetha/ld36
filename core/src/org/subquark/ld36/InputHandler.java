package org.subquark.ld36;

import java.util.Objects;

import org.subquark.ld36.camp.Camp;
import org.subquark.ld36.digsite.DigSite;
import org.subquark.ld36.goals.BuildCooldownUpdater;
import org.subquark.ld36.research_camp.ResearchCamp;
import org.subquark.ld36.scanner.Scanner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

public class InputHandler implements InputProcessor {
    public enum SelectedItem { Camp, Scanner, DigSite, Research, Nothing }
    private SelectedItem selectedItem = SelectedItem.Nothing;
    
    private final LudumDare36Entry mainApp;
    private final GameState gameState;
    private final Viewport viewport;
    
    public InputHandler(LudumDare36Entry mainApp, Viewport viewport, GameState gameState) {
        this.mainApp = mainApp;
        this.gameState = gameState;
        this.viewport = viewport;
    }
    
    public SelectedItem getSelectedItem() {
        return selectedItem;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.F3) {
            gameState.debugging = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.F3) {
            gameState.debugging = false;
            return true;
        }

        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer,
            int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (button == Input.Buttons.RIGHT) {
            selectedItem = SelectedItem.Nothing;
            Gdx.app.log("input handler", "deselected");
            return true;
        }
        
        Vector2 screenCoords = new Vector2(screenX, screenY);
        Vector2 worldCoords = viewport.unproject(screenCoords);
        int clickX = (int) worldCoords.x;
        int clickY = (int) worldCoords.y;
        
        if (20 <= clickX && clickX <= 480 && 20 <= clickY && clickY <= 430) {
            if (gameState.buildCooldown >= 0) {
                return true;
            }
            
            switch(selectedItem) {
                case Camp:
                    Camp newCamp = new Camp();
                    gameState.camps.add(newCamp);
                    newCamp.x = clickX;
                    newCamp.y = clickY;
                    gameState.buildCooldown = BuildCooldownUpdater.BUILD_COOLDOWN;
                    break;
                case DigSite:
                    DigSite newDig = new DigSite();
                    gameState.digSites.add(newDig);
                    newDig.x = clickX;
                    newDig.y = clickY;
                    gameState.buildCooldown = BuildCooldownUpdater.BUILD_COOLDOWN;
                    break;
                case Nothing:
                    break;
                case Research :
                    ResearchCamp newResearchCamp = new ResearchCamp();
                    gameState.researchCamps.add(newResearchCamp);
                    newResearchCamp.x = clickX;
                    newResearchCamp.y = clickY;
                    gameState.buildCooldown = BuildCooldownUpdater.BUILD_COOLDOWN;
                    break;
                case Scanner:
                    Scanner newScanner = new Scanner();
                    gameState.scanners.add(newScanner);
                    newScanner.x = clickX;
                    newScanner.y = clickY;
                    gameState.buildCooldown = BuildCooldownUpdater.BUILD_COOLDOWN;
                    break;
                default :
                    break;
                
            }
            Gdx.app.log("Input handler", "Buying");
            return true;
        } else {
            if (clickX < 500) {
                return false;
            }
            if (350 <= clickY && clickY <= 400) {
                selectedItem = SelectedItem.Camp;
            } else if (300 <= clickY && clickY <= 350) {
                selectedItem = SelectedItem.Scanner;
            } else if (250 <= clickY && clickY <= 300) {
                selectedItem = SelectedItem.DigSite;
            } else if (200 <= clickY && clickY <= 250) {
                selectedItem = SelectedItem.Research;
            }
            Gdx.app.log("input handler", "selected: " + Objects.toString(selectedItem));
            return true;
        }
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public void resetSelectedItem() {
        selectedItem = SelectedItem.Nothing;
    }
}
