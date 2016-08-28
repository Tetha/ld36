package org.subquark.ld36;

import java.util.Random;

import org.subquark.ld36.camp.Camp;
import org.subquark.ld36.camp.CampDisplay;
import org.subquark.ld36.camp.CampUpdater;
import org.subquark.ld36.digsite.DigSiteDisplay;
import org.subquark.ld36.digsite.DigSiteUpdater;
import org.subquark.ld36.goals.BuildCooldownUpdater;
import org.subquark.ld36.goals.EndGameInputHandler;
import org.subquark.ld36.goals.TimeConstraint;
import org.subquark.ld36.goals.TimeLimitUpdater;
import org.subquark.ld36.goals.TreasureDensity;
import org.subquark.ld36.goals.VictoryBannerDisplay;
import org.subquark.ld36.level.Level;
import org.subquark.ld36.level.LevelDisplay;
import org.subquark.ld36.menu.MenuDisplay;
import org.subquark.ld36.menu.MenuInputHandler;
import org.subquark.ld36.particels.ParticleDisplay;
import org.subquark.ld36.particels.ParticleUpdater;
import org.subquark.ld36.research_camp.ResearchCampDisplay;
import org.subquark.ld36.research_camp.ResearchCampUpdater;
import org.subquark.ld36.scanner.Scanner;
import org.subquark.ld36.scanner.ScannerDisplay;
import org.subquark.ld36.scanner.ScannerUpdater;
import org.subquark.ld36.shop.TopLevelDisplay;
import org.subquark.ld36.shop.ShopDisplay;
import org.subquark.ld36.workers.Worker;
import org.subquark.ld36.workers.WorkerDisplay;
import org.subquark.ld36.workers.WorkerUpdater;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class LudumDare36Entry extends ApplicationAdapter {
    private enum ApplicationState {
        MENU,
        INGAME,
        ENDGAME,
    };
    
    private ShapeRenderer renderer;
	private Camera camera;
	private Viewport viewport;
	
	private ApplicationState applicationState;
	
	Random levelGenRandom = new Random();
	Random otherRandom = new Random();
	
	private GameState gameState = new GameState();
    private WorkerUpdater workerUpdater;
	private CampUpdater campUpdater;
	private ScannerUpdater scannerUpdater;
	private DigSiteUpdater digSiteUpdater;
	private ResearchCampUpdater researchCampUpdater;
	private TimeLimitUpdater timeLimitUpdater;
	private BuildCooldownUpdater buildCooldownUpdater;
	private ParticleUpdater particleUpdater;
	
	private InputHandler inputHandler;
	private InputProcessor endGameInputHandler;
	private MenuInputHandler menuInputHandler;
	
	private MenuDisplay menuDisplay;
	private LevelDisplay levelDisplay;
	private WorkerDisplay workerDisplay;
	private CampDisplay campDisplay;
	private ScannerDisplay scannerDisplay;
	private ShopDisplay shopDisplay;
	private DigSiteDisplay digSiteDisplay;
	private TopLevelDisplay artifactCountDisplay;
	private ResearchCampDisplay researchCampDisplay;
	private VictoryBannerDisplay victoryBannerDisplay;
	private ParticleDisplay particleDisplay;
	
	private Textures textures;
	
	@Override
	public void create () {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        textures = new Textures();
        
        renderer = new ShapeRenderer();
        camera = new PerspectiveCamera();
        viewport = new FitViewport(640, 480);
				
        inputHandler = new InputHandler(this, viewport, gameState);
        endGameInputHandler = new EndGameInputHandler(this);
        menuInputHandler = new MenuInputHandler(this, viewport);
        
        workerUpdater = new WorkerUpdater(gameState);
        campUpdater = new CampUpdater(gameState);
        scannerUpdater = new ScannerUpdater(otherRandom, gameState);
        digSiteUpdater = new DigSiteUpdater(otherRandom, gameState);
        researchCampUpdater = new ResearchCampUpdater(gameState);
        timeLimitUpdater = new TimeLimitUpdater(gameState);
        buildCooldownUpdater = new BuildCooldownUpdater(gameState);
        particleUpdater = new ParticleUpdater(gameState);
        
		workerDisplay = new WorkerDisplay(textures, gameState);
		campDisplay = new CampDisplay(textures, gameState);
		scannerDisplay = new ScannerDisplay(textures, gameState);
		levelDisplay = new LevelDisplay(textures, gameState);
		shopDisplay = new ShopDisplay(textures, gameState, inputHandler);
		digSiteDisplay = new DigSiteDisplay(textures, gameState);
		artifactCountDisplay = new TopLevelDisplay(textures, gameState);
		researchCampDisplay = new ResearchCampDisplay(textures, gameState);
		victoryBannerDisplay = new VictoryBannerDisplay(textures, gameState);
		particleDisplay = new ParticleDisplay(textures, gameState);
		
		menuDisplay = new MenuDisplay(textures, gameState, menuInputHandler);

		transistToMenu();
	}

	public void transistToMenu() {
	    applicationState = ApplicationState.MENU;
        Gdx.input.setInputProcessor(menuInputHandler);
	}

	public void transistToEndgame() {
        applicationState = ApplicationState.ENDGAME;
        Gdx.input.setInputProcessor(endGameInputHandler);
    }
	
	public void transistToGame(TreasureDensity treasureDensity, TimeConstraint timeConstraint) {
	    applicationState = ApplicationState.INGAME;
        gameState.reset(levelGenRandom, treasureDensity, timeConstraint, 50);
        inputHandler.resetSelectedItem();
        Gdx.input.setInputProcessor(inputHandler);
	}
    
	@Override
	public void resize(int width, int height) {
        viewport.update(width, height, true);
    }
    
	@Override
	public void render () {
		Gdx.gl.glClearColor(100f / 255, 100f / 255, 100f / 255, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		switch(applicationState) {
            case ENDGAME:
                victoryBannerDisplay.update();
                break;
                
            case INGAME:
                workerUpdater.update();
                
                campUpdater.update();
                scannerUpdater.update();
                digSiteUpdater.update();
                researchCampUpdater.update();
                timeLimitUpdater.update();
                buildCooldownUpdater.update();
                particleUpdater.update();
                
                if (gameState.debugging) {
                    drawGrid();
                } else {
                    levelDisplay.update();
                }
                campDisplay.update();
                scannerDisplay.update();
                digSiteDisplay.update();
                researchCampDisplay.update();
                
                workerDisplay.update();
                particleDisplay.update();
                
                shopDisplay.update();
                artifactCountDisplay.update();
                
                if (gameState.remainingTime() <= 0) {
                    transistToEndgame();
                    Gdx.input.setInputProcessor(endGameInputHandler);
                }
                if (gameState.researchedArtifacts >= gameState.artifactsRequired) {
                    transistToEndgame();
                    Gdx.input.setInputProcessor(endGameInputHandler);
                }
                break;
            case MENU :
                menuDisplay.update();
                break;
            default :
                break;
		    
		}
	}
	
	private void drawGrid() {
	    renderer.begin(ShapeType.Filled);
	    for (int i = 0; i < Level.WIDTH_TILES; i++) {
	        for (int j = 0; j < Level.HEIGHT_TILES; j++) {
	            float noiseHere = gameState.level.getRawNoiseAt(i, j);
	            if (noiseHere > gameState.level.treasureThreshold) {
	                renderer.setColor(noiseHere, noiseHere, noiseHere, noiseHere);
	            } else {
	                renderer.setColor(Color.BLACK);
	            }
	            renderer.rect(i * 10, j * 10, 10, 10);
	        }
	    }
	    renderer.end();
	}
	@Override
	public void dispose () {
	    textures.dispose();
	}
}
