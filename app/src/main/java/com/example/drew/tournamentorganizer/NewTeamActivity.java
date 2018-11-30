package com.example.drew.tournamentorganizer;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewTeamActivity extends AppCompatActivity {
    EditText teamName, teamComments;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_team);
        getSupportActionBar().setTitle("Create Team");
        configureCancelButton();
        configureSaveButton();
    }

    private void configureCancelButton(){
        Button cancelButton = findViewById(R.id.new_team_cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void configureSaveButton(){
        saveButton = (Button)findViewById(R.id.new_team_save_button);
        teamName = (EditText)findViewById(R.id.new_team_name);
        teamComments = (EditText)findViewById(R.id.new_team_comments);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!teamName.getText().toString().equals("")){
                    // add data to the db
                    DatabaseHelper db = new DatabaseHelper(getBaseContext());
                    db.addTeam(teamName.getText().toString(), teamComments.getText().toString());

                    //pass data back to the parent activity
                    getIntent().putExtra("NEW_TEAM_NAME",teamName.getText().toString());
                    getIntent().putExtra("NEW_TEAM_COMMENTS", teamComments.getText().toString());
                    setResult(900,getIntent());
                    finish();
                }else{
                    Toast.makeText(getBaseContext() ,"Please at least include a team name", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
