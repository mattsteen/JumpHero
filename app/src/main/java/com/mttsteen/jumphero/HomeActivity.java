package com.mttsteen.jumphero;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class HomeActivity extends Activity {

    // Member **********

    private int number = 0;
    private String name = "Matt";

    // Method *************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    public void startGame(View view) {

        Log.v("Matt", "Starting the Game!");

        Intent startGameIntent = new Intent(this, GameActivity.class);
        startActivity(startGameIntent);

    }

}
