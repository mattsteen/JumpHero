package com.mttsteen.jumphero.animation;

import android.graphics.Point;

import com.mttsteen.jumphero.gameobject.Enemy;
import com.mttsteen.jumphero.gameobject.GameObject;

/**
 * Created by mattst on 9/9/14.
 */
public class HorizontalAnimation extends GameObjectAnimation {

    private Point startingPosition = new Point();
    private final int SPEED = 20;
    private boolean moveLeftToRight = true;
    private int outOfboundsX = 0;

    public HorizontalAnimation(GameObject gameObject, boolean moveLeftToRight, int outOfboundsX) {

        super(gameObject);
        this.startingPosition.set(gameObject.getPosition().x, gameObject.getPosition().y);
        this.moveLeftToRight = moveLeftToRight;
        this.outOfboundsX = outOfboundsX;

    }

    @Override
    public void animate() {

        super.animate();

        boolean isAnimationComplete = false;

        if (moveLeftToRight) {

            getGameObjectRef().getPosition().x += SPEED;

            if (getGameObjectRef().getPosition().x >= outOfboundsX) {

               isAnimationComplete = true;

            }

        } else {

            getGameObjectRef().getPosition().x -= SPEED;

            if (getGameObjectRef().getPosition().x <= outOfboundsX) {

                isAnimationComplete = true;

            }

        }

        if (isAnimationComplete) {

            animationComplete();

        }



    }

    @Override
    public void animationComplete() {

        super.animationComplete();

        getGameObjectRef().setPosition(startingPosition);
        getGameObjectRef().setGameObjectAnimation(null);

    }
}
