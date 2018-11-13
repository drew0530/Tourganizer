package com.example.drew.tournamentorganizer;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class NewTournamentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Create Tournament");
        setContentView(R.layout.activity_new_tournament);
        configureSaveButton();
        configureCancelButton();
    }

    private void configureCancelButton(){
        Button cancelButton = (Button) findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });
    }

    private void configureSaveButton(){
        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            TextView tournamentName = (TextView)  findViewById(R.id.tournamentName);
            setResult(Activity.RESULT_OK,
                new Intent().putExtra("tournamentName", tournamentName.getText().toString()));
            finish();
            }
        });
    }
}
