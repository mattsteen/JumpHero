package com.mttsteen.jumphero.gameobject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.WindowManager;

import com.mttsteen.jumphero.animation.GameObjectAnimation;

/**
 * Created by mattst on 9/6/14.
 */
public abstract class GameObject {

    private Point position;
    private int width;
    private int height;
    private Drawable sprite;
    private GameObjectAnimation gameObjectAnimation = null;

    public GameObject(Point defaultPosition) {
        position = defaultPosition;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Drawable getSprite() {
        return sprite;
    }

    public void setSprite(Drawable sprite) {
        this.sprite = sprite;
    }

    public GameObjectAnimation getGameObjectAnimation() {
        return gameObjectAnimation;
    }

    public void setGameObjectAnimation(GameObjectAnimation gameObjectAnimation) {
        this.gameObjectAnimation = gameObjectAnimation;
    }

    public void flipOrientation(Context context) {

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        position.set(position.x, size.y - position.y);

    }

    public abstract void draw(Canvas canvas);
    public abstract void update(long currentTime);



}
