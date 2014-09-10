package com.mttsteen.jumphero.drawing;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by mattst on 5/27/14.
 */
public class PaintHelper {

    public Paint GRAY_FILL;
    public Paint LTGRAY_FILL;
    public Paint CYAN_FILL;
    public Paint GREEN_FILL;
    public Paint YELLOW_FILL;
    public Paint PURPLE_FILL;
    public Paint MAGENTA_FILL;
    public Paint ORANGE_FILL;
    public Paint RED_FILL;

    public PaintHelper() {

        GRAY_FILL = new Paint();
        GRAY_FILL.setColor(Color.GRAY);
        GRAY_FILL.setStyle(Paint.Style.FILL);

        LTGRAY_FILL = new Paint();
        LTGRAY_FILL.setColor(Color.LTGRAY);
        LTGRAY_FILL.setStyle(Paint.Style.FILL);

        CYAN_FILL = new Paint();
        CYAN_FILL.setColor(Color.parseColor("#8be6fa"));
        CYAN_FILL.setStyle(Paint.Style.FILL);

        GREEN_FILL = new Paint();
        GREEN_FILL.setColor(Color.parseColor("#a3eb31"));
        GREEN_FILL.setStyle(Paint.Style.FILL);

        PURPLE_FILL = new Paint();
        PURPLE_FILL.setColor(Color.parseColor("#f98bfa"));
        PURPLE_FILL.setStyle(Paint.Style.FILL);

        MAGENTA_FILL = new Paint();
        MAGENTA_FILL.setColor(Color.parseColor("#f61dfe"));
        MAGENTA_FILL.setStyle(Paint.Style.FILL);

        ORANGE_FILL = new Paint();
        ORANGE_FILL.setColor(Color.parseColor("#ffa422"));
        ORANGE_FILL.setStyle(Paint.Style.FILL);


    }

    public static Paint createPaint(String colorHex, Paint.Style style) {

        Paint paint = new Paint();
        paint.setColor(Color.parseColor(colorHex));
        paint.setStyle(style);

        return paint;
    }

    public static Paint RED_FILL() {

        return createPaint("#f64445", Paint.Style.FILL);

    }

    public static Paint YELLOW_FILL() {

        return createPaint("#f6fe1d", Paint.Style.FILL);

    }
}
