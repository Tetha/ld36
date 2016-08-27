package org.subquark.ld36;

import java.util.ArrayList;
import java.util.List;

import org.subquark.ld36.workers.Worker;
import org.subquark.ld36.workers.WorkerDisplay;
import org.subquark.ld36.workers.WorkerUpdater;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LudumDare36Entry extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	private List<Worker> workers;
	
	private WorkerUpdater workerUpdater;
	
	private WorkerDisplay workerDisplay;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		workers = new ArrayList<Worker>();
		
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		
        workerUpdater = new WorkerUpdater(workers);
        
		workerDisplay = new WorkerDisplay(workers);
		
		Worker testWorker = new Worker();
		testWorker.x = 100;
		testWorker.y = 100;
		testWorker.lifetimeLeft = Worker.START_LIFETIME_MS;
		
		workers.add(testWorker);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		workerDisplay.update();
		workerUpdater.update();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
