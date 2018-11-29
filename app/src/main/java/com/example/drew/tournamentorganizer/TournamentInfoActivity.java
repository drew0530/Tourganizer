package com.example.drew.tournamentorganizer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Drew on 11/16/18.
 */

public class TournamentInfoActivity extends AppCompatActivity {

    private ImageView imageViewTeam1, imageViewTeam2;
    private TextView textViewTournamentName, textViewDate, textViewTeam1Name, textViewTeam2Name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_details);
        //Set up action bar
        getSupportActionBar().setTitle("Tournament Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Define all View items
        imageViewTeam1 = this.findViewById(R.id.team1Image);
        imageViewTeam2 = this.findViewById(R.id.team2Image);
        textViewTournamentName = this.findViewById(R.id.tournament_name);
        textViewDate = this.findViewById(R.id.match_time);
        textViewTeam1Name = this.findViewById(R.id.team1Text);
        textViewTeam2Name = this.findViewById(R.id.team2Text);

        // Grab data from intent and store it in our view items
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras != null) {
                textViewTournamentName.setText(extras.getString("TOURNAMENT_NAME"));
                textViewDate.setText(extras.getString("TOURNAMENT_DATE"));
                textViewTeam1Name.setText(extras.getString("TEAM_1_NAME"));
                textViewTeam2Name.setText(extras.getString("TEAM_2_NAME"));
                // TODO Find a way to send images through intent, i.e. pull them from file
                // could store the filePath in the database, and use path string to pass through intent
//                imageViewTeam1.setImageDrawable(extras.getString("TEAM_2_IMAGE"));
//                imageViewTeam2.setImageDrawable(extras.getString("TEAM_2_IMAGE"));
            }
        } else {
            savedInstanceState.getSerializable("STRING_I_NEED");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tournament_details_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_bracket:
                // User chose the "Bracket" item, show the tournament bracket UI...
                // TODO NEED TO PASS DATA TO THIS INTENT
                Intent intent = new Intent(TournamentInfoActivity.this, TournamentBracket4Activity.class);
                startActivity(intent);
                return true;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
