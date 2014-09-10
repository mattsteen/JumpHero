package com.mttsteen.jumphero.drawing;

import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by mattst on 9/8/14.
 */
public class ShapeHelper {

    public static Rect createRectangleWithCenterAt(Point point, int width, int height) {

        return new Rect(
            point.x - (width/2),
            point.y + (height/2),
            point.x + (width/2),
            point.y - (height/2));

    }

}
