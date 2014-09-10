package com.mttsteen.jumphero;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.mttsteen.jumphero.gameobject.Enemy;
import com.mttsteen.jumphero.gameobject.GameObject;
import com.mttsteen.jumphero.gameobject.Hero;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mattst on 5/23/14.
 */
public class GameSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private Context activityContext;
    private SurfaceHolder surfaceHolder;
    private GameLoopThread gameLoopThread;
    private Hero heroRef = null;
    private List<GameObject> gameObjects = new ArrayList<GameObject>();

    public GameSurfaceView(Context context) {

        super(context);
        activityContext = context;
        getHolder().addCallback(this);

        // create the game loop thread
        gameLoopThread = new GameLoopThread(getHolder(), this);

        setFocusable(true);

        resetGame();

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        gameLoopThread.start();
        startGameThread();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        // tell the thread to shut down and wait for it to finish
        // this is a clean shutdown

        boolean retry = true;

        while (retry) {

            try {
                gameLoopThread.join();
                retry = false;
            } catch (InterruptedException e) {
                // try again shutting down the thread
            }
        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            if (event.getY() > getHeight() - 50) {

                gameLoopThread.setRunning(false);
                ((Activity)getContext()).finish();

            } else {

                heroRef.jump();

                Log.d(Util.TAG, "Hero: " + heroRef.getPosition().x + ", " + heroRef.getPosition().y);

            }

        }

        return super.onTouchEvent(event);

    }

    public void startGameThread() {

        gameLoopThread.setRunning(true);

    }

    public void stopGameThread() {

        gameLoopThread.setRunning(false);

    }

    public void update(long currentTime) {

        for (GameObject gameObject : gameObjects) {

            gameObject.update(currentTime);

        }

    }

    public void render(Canvas canvas) {

        if (canvas != null) {

            canvas.drawColor(Color.BLACK);

            for (GameObject gameObject : gameObjects) {

                gameObject.flipOrientation(activityContext);
                gameObject.draw(canvas);
                gameObject.flipOrientation(activityContext);

            }

        }

    }

    public void resetGame() {

        heroRef = new Hero(new Point(500, 100));

        gameObjects.add(heroRef);
        gameObjects.add(new Enemy(new Point(0, 100)));
        gameObjects.add(new Enemy(new Point(1080, 100)));

    }

}
