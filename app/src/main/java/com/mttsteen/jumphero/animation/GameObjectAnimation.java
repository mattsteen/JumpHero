package com.mttsteen.jumphero.animation;

import com.mttsteen.jumphero.gameobject.GameObject;

import java.util.Date;

/**
 * Created by mattst on 9/8/14.
 */
public abstract class GameObjectAnimation  {

    private long startTime;
    private int ticks = 0;
    private GameObject gameObjectRef;

    public GameObjectAnimation(GameObject gameObject) {

        gameObjectRef = gameObject;
        animationCreate();

    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public GameObject getGameObjectRef() {
        return gameObjectRef;
    }

    public int getTicks() {
        return ticks;
    }

    public long getAnimationDuration(long currentTime) {

        return (currentTime - startTime);

    }

    public void animationCreate() {

        startTime = new Date().getTime();

    }

    public void animationComplete() {

        gameObjectRef.setGameObjectAnimation(null);

    }

    public void animate() {

        ticks++;

    }


}
