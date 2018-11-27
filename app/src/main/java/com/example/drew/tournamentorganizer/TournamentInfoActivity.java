package com.example.drew.tournamentorganizer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by Drew on 11/16/18.
 */

public class TournamentInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_info);
        getSupportActionBar().setTitle("Tournament Info");
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            // action with ID action_refresh was selected
//            case R.id.action_refresh:
//                // do something
//                break;
//            // action with ID action_settings was selected
//            case R.id.action_settings:
//                // do something
//                break;
//            default:
//                break;
//        }
//
//        return true;
//    }
}
