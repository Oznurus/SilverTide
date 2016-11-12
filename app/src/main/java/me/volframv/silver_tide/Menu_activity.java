package me.volframv.silver_tide;

import android.app.ActionBar;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;


public class Menu_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_activity);
        System.out.println("OnCreate");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    public void onWorkoutTap(View v){
        Toast myToast = Toast.makeText(getApplicationContext(),"Hello World!",Toast.LENGTH_LONG);
        myToast.show();
        System.out.println("Toast is hot");

        //Create intent
        Intent getNameScreenIntent = new Intent(this,Workout_activity.class);
        // Pass into into intent
        getNameScreenIntent.putExtra("workoutActivity", "Menu_activity");
        startActivity(getNameScreenIntent);
    }
    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("OnPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
