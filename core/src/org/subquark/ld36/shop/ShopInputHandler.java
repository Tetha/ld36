package org.subquark.ld36.shop;

import java.util.List;
import java.util.Objects;

import org.subquark.ld36.camp.Camp;
import org.subquark.ld36.scanner.Scanner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class ShopInputHandler implements InputProcessor {
    public enum SelectedItem { Camp, Scanner, DigSite, Research, Nothing }
    private SelectedItem selectedItem = SelectedItem.Nothing;
    
    private final List<Camp> camps;
    private final List<Scanner> scanners;
    
    public ShopInputHandler(List<Camp> camps, List<Scanner> scanners) {
        this.camps = camps;
        this.scanners = scanners;
    }
    
    public SelectedItem getSelectedItem() {
        return selectedItem;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
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
        int clickX = screenX;
        int clickY = Gdx.graphics.getHeight() - screenY;
        
        if (20 <= clickX && clickX <= 480 && 20 <= clickY && clickY <= 430) {
            switch(selectedItem) {
                case Camp:
                    Camp newCamp = new Camp();
                    camps.add(newCamp);
                    newCamp.x = clickX;
                    newCamp.y = clickY;
                    break;
                case DigSite:
                    break;
                case Nothing:
                    break;
                case Research :
                    break;
                case Scanner:
                    Scanner newScanner = new Scanner();
                    scanners.add(newScanner);
                    newScanner.x = clickX;
                    newScanner.y = clickY;
                    
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
            if (0 <= clickY && clickY <= 100) {
                selectedItem = SelectedItem.Camp;
            } else if (100 <= clickY && clickY <= 200) {
                selectedItem = SelectedItem.Scanner;
            } else if (200 <= clickY && clickY <= 300) {
                selectedItem = SelectedItem.DigSite;
            } else if (300 <= clickY && clickY <= 400) {
                selectedItem = SelectedItem.Research;
            } else if (400 <= clickY && clickY <= 500) {
                selectedItem = SelectedItem.Nothing;
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
}
