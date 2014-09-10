package com.mttsteen.jumphero.animation;

import android.graphics.Point;
import android.util.Log;

import com.mttsteen.jumphero.Util;
import com.mttsteen.jumphero.gameobject.GameObject;
import com.mttsteen.jumphero.gameobject.Hero;

/**
 * Created by mattst on 9/8/14.
 */
public class JumpAnimation extends GameObjectAnimation {

    private int jumpHeight = 400;
    private Point startingPosition = new Point();
    private Point endingPosition = new Point();

    public JumpAnimation(GameObject gameObject, Point endingPosition) {

        super(gameObject);
        this.startingPosition.set(gameObject.getPosition().x, gameObject.getPosition().y);
        this.endingPosition.set(endingPosition.x, endingPosition.y);
    }

    @Override
    public void animate() {

        super.animate();

        Point gameObjectPoint = getGameObjectRef().getPosition();

        // y = -(ax - b)^2 + c
        // y = -((jumpSpeed * ticks) - sqrt(jumpHeight))^2 + jumpHeight

        int jumpSpeed = 2;
        int currentTicks = getTicks() - 1;
        int y = -(int)Math.pow(((jumpSpeed * currentTicks) - Math.sqrt(jumpHeight)), 2) + jumpHeight;

        gameObjectPoint.y = startingPosition.y + y;

        if (gameObjectPoint.y < endingPosition.y) {

            animationComplete();

        }

        Log.v(Util.TAG, "y: " + y + " | jump: " + gameObjectPoint.x + ", " + gameObjectPoint.y);

    }

    @Override
    public void animationComplete() {

        super.animationComplete();
        getGameObjectRef().getPosition().y = endingPosition.y;

        Hero hero = (Hero)getGameObjectRef();
        hero.setJumpCount(0);
        hero.setJumpEndingPosition(null);

    }

}
