package com.mttsteen.jumphero.gameobject;

import android.graphics.Canvas;
import android.graphics.Point;

import com.mttsteen.jumphero.animation.HorizontalAnimation;
import com.mttsteen.jumphero.animation.JumpAnimation;
import com.mttsteen.jumphero.drawing.PaintHelper;
import com.mttsteen.jumphero.drawing.ShapeHelper;

/**
 * Created by mattst on 9/6/14.
 */
public class Enemy extends GameObject {

    private int damage;

    public Enemy(Point defaultPosition) {

        super(defaultPosition);

        this.setWidth(50);
        this.setHeight(50);

    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public void draw(Canvas canvas) {

        canvas.drawRect(
                ShapeHelper.createRectangleWithCenterAt(this.getPosition(), this.getWidth(), this.getHeight()),
                PaintHelper.YELLOW_FILL());

    }

    @Override
    public void update(long currentTime) {

        if (getGameObjectAnimation() == null) {

            if (getPosition().x == 0) {
                fireLeftToRight();
            } else {
                fireRightToLeft();
            }

        } else {

            getGameObjectAnimation().animate();
            
        }

    }

    private void fire(boolean moveLeftToRight, int outOfBoundsX) {

        if (getGameObjectAnimation() == null) {

            setGameObjectAnimation(new HorizontalAnimation(this, moveLeftToRight, outOfBoundsX));

        }

    }

    public void fireLeftToRight() {

        fire(true, 1200);

    }

    public void fireRightToLeft() {

        fire(false, -120);

    }

}
