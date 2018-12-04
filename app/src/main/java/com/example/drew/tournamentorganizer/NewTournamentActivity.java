package com.example.drew.tournamentorganizer;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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
        configureAddTeamButton();
        configureCancelButton();
    }

    private void configureAddTeamButton(){
        Button addTeamBtn = findViewById(R.id.addTeamButton);
        addTeamBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // setup the alert builder
                AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext());
                builder.setTitle("Choose some animals");

                // add a checkbox list
                String[] animals = {"horse", "cow", "camel", "sheep", "goat"};
                boolean[] checkedItems = {true, false, false, true, false};
                builder.setMultiChoiceItems(animals, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        // user checked or unchecked a box
                    }
                });

                // add OK and Cancel buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // user clicked OK
                    }
                });
                builder.setNegativeButton("Cancel", null);

                // create and show the alert dialog
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    private void configureCancelButton(){
        Button cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });
    }

    private void configureSaveButton(){
        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            TextView tournamentName = findViewById(R.id.tournamentName);
            setResult(Activity.RESULT_OK,
                new Intent().putExtra("tournamentName", tournamentName.getText().toString()));
            finish();
            }
        });
    }
}
