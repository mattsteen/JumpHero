package com.mttsteen.jumphero.gameobject;

import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;

import com.mttsteen.jumphero.Util;
import com.mttsteen.jumphero.animation.JumpAnimation;
import com.mttsteen.jumphero.drawing.PaintHelper;
import com.mttsteen.jumphero.drawing.ShapeHelper;

/**
 * Created by mattst on 9/6/14.
 */
public class Hero extends GameObject {

    private int health;
    private int jumpCount = 0;
    private Point jumpEndingPosition = null;
    private final int JUMP_MAX = 2;

    public Hero(Point defaultPosition) {

        super(defaultPosition);

        this.setWidth(100);
        this.setHeight(100);

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getJumpCount() {
        return jumpCount;
    }

    public void setJumpCount(int jumpCount) {
        this.jumpCount = jumpCount;
    }

    public Point getJumpEndingPosition() {
        return jumpEndingPosition;
    }

    public void setJumpEndingPosition(Point jumpEndingPosition) {
        this.jumpEndingPosition = jumpEndingPosition;
    }

    @Override
    public void update(long currentTime) {

        if (getGameObjectAnimation() != null) {
            getGameObjectAnimation().animate();
        }
    }

    @Override
    public void draw(Canvas canvas) {

        canvas.drawRect(
                ShapeHelper.createRectangleWithCenterAt(this.getPosition(), this.getWidth(), this.getHeight()),
                PaintHelper.RED_FILL());

    }

    public void jump() {

        if (jumpCount < JUMP_MAX) {

             if (jumpEndingPosition == null) {

                 jumpEndingPosition = new Point(this.getPosition().x, this.getPosition().y);

             }

             Log.v(Util.TAG, "jumpEndingPosition: " + jumpEndingPosition.x + ", " + jumpEndingPosition.y);
             setGameObjectAnimation(new JumpAnimation(this, jumpEndingPosition));
             jumpCount++;

        }

    }
}
