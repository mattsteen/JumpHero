package com.mttsteen.jumphero;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class GameActivity extends Activity {

    private Handler gameLoopHander = new Handler();
    private GameSurfaceView gameSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setFullScreenMode();

        gameSurfaceView = new GameSurfaceView(this);

        setContentView(gameSurfaceView);

        Log.d(Util.TAG, "View added");

    }

    @Override
    protected void onResume() {

        Log.d(Util.TAG, "Destroying...");
        super.onResume();

        gameSurfaceView.startGameThread();

    }

    @Override
    protected void onPause() {

        Log.d(Util.TAG, "Destroying...");
        super.onResume();

        gameSurfaceView.stopGameThread();

    }

    @Override
    protected void onDestroy() {

        Log.d(Util.TAG, "Destroying...");
        super.onDestroy();

    }

    @Override
    protected void onStop() {

        Log.d(Util.TAG, "Stopping...");
        super.onStop();

    }

    private void setFullScreenMode() {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

    }



}
