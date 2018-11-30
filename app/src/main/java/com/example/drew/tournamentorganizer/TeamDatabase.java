package com.example.drew.tournamentorganizer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TeamDatabase extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "tournamentDatabase.db";
    //First table
    /*
     ________________________________________________
    |_TeamID_|_teamName_|_teamCaptain_|_matchRating__|
    |________|__________|_____________|______________|
     */
    public static final String TEAMS_TABLE_NAME = "Teams";
    public static final String COL_1 = "TeamID";
    public static final String COL_2 = "TeamName";
    public static final String COL_3 = "TeamComments";
    /*
     _________________________________________________________________________________
    |_TournamentID_|_TournamentName_|_Team1_|_Team2_|_Team3_|_Team4_|_TournamentStyle_|
    |______________|________________|_______|_______|_______|_______|_________________|
    */
    public static final String TOURNAMENTS_4_TABLE_NAME = "Tournaments";
    public static final String TOUR4_1 = "TournamentID";
    public static final String TOUR4_2 = "TournamentName";
    public static final String TOUR4_3 = "Team1";
    public static final String TOUR4_4 = "Team2";
    public static final String TOUR4_5 = "Team3";
    public static final String TOUR4_6 = "Team4";
    public static final String TOUR4_7 = "TournamentStyle";
    //TODO: Add more tables for 16 team tournaments
    // Table for 8-man tournaments
//    public static final String TOURN8_NAME = "tourn8Table";
//    public static final String TOUR8_1 = "tournamentID";
//    public static final String TOUR8_2 = "tournamentName";
//    public static final String TOUR8_3 = "tournamentType";
//    public static final String TOUR8_4 = "team1";
//    public static final String TOUR8_5 = "team2";
//    public static final String TOUR8_6 = "team3";
//    public static final String TOUR8_7 = "team4";
//    public static final String TOUR8_8 = "team5";
//    public static final String TOUR8_9 = "team6";
//    public static final String TOUR8_10 = "team7";
//    public static final String TOUR8_11 = "team8";
//    public static final String TOUR8_12 = "team1Status";
//    public static final String TOUR8_13 = "team2Status";
//    public static final String TOUR8_14 = "team3Status";
//    public static final String TOUR8_15 = "team4Status";
//    public static final String TOUR8_16 = "team5Status";
//    public static final String TOUR8_17 = "team6Status";
//    public static final String TOUR8_18 = "team7Status";
//    public static final String TOUR8_19 = "team8Status";
//    public static final String TABLE_NAME = "teamTable";

    public TeamDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Formatted for readability
        db.execSQL("create table " + TEAMS_TABLE_NAME + " (" +
                "TeamID BIGINT PRIMARY KEY AUTOINCREMENT, " +
                "TeamName TEXT,  " +
                "TeamComments TEXT" +
                ")"
        );

        //Formatted for readability
        db.execSQL("create table " + TOURNAMENTS_4_TABLE_NAME + " (" +
                "TournamentID BIGINT PRIMARY KEY AUTOINCREMENT, " +
                "TournamentName TEXT, " +
                "Team1 BIGINT, " +
                "Team2 BIGINT, " +
                "Team3 BIGINT, " +
                "Team4 BIGINT, " +
                "TournamentStyle TEXT, " +
                "FOREIGN KEY (Team1) REFERENCES Teams(TeamID), " +
                "FOREIGN KEY (Team2) REFERENCES Teams(TeamID), " +
                "FOREIGN KEY (Team3) REFERENCES Teams(TeamID), " +
                "FOREIGN KEY (Team4) REFERENCES Teams(TeamID)" +
                ")"
        );

//        db.execSQL("create table " + TOURN8_NAME + " (tournamentID INTEGER PRIMARY KEY AUTOINCREMENT, tournamentName TEXT, tournamentType TEXT, team1 TEXT,team1Status INT, team2 TEXT, team2Status INT,team3 TEXT,team3Status INT,team4 TEXT,team4Status INT, team5 TEXT,team5Status INT, team6 TEXT, team6Status INT,team7 TEXT,team7Status INT,team8 TEXT,team8Status INT)");
    }

    /* Only call this if you want to delete everything in the database and start over. */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TEAMS_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TOURNAMENTS_4_TABLE_NAME);
//        db.execSQL("DROP TABLE IF EXISTS " + TOURN8_NAME);
        onCreate(db);
    }

    public boolean addTeam(String teamName, String teamComments){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_2, teamName);
        cv.put(COL_3, teamComments);
        long result = db.insert(TEAMS_TABLE_NAME, null, cv);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean addTourn4(String tournamentName, int team1, int team2, int team3, int team4, String tournamentStyle){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TOUR4_2, tournamentName);
        cv.put(TOUR4_3, team1);
        cv.put(TOUR4_4, team2);
        cv.put(TOUR4_5, team3);
        cv.put(TOUR4_6, team4);
        cv.put(TOUR4_7, tournamentStyle);

        long result = db.insert(TOURNAMENTS_4_TABLE_NAME, null, cv);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

//    public boolean addTourn8(String tournamentName, String tournamentType, int team1, int team2, int team3, int team4, int team5, int team6, int team7, int team8 ,int team1Status, int team2Status, int team3Status, int team4Status, int team5Status, int team6Status, int team7Status, int team8Status){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put(TOUR8_2, tournamentName);
//        cv.put(TOUR8_3, tournamentType);
//        cv.put(TOUR8_4, team1);
//        cv.put(TOUR8_5, team2);
//        cv.put(TOUR8_6, team3);
//        cv.put(TOUR8_7, team4);
//        cv.put(TOUR8_8, team5);
//        cv.put(TOUR8_9, team6);
//        cv.put(TOUR8_10, team7);
//        cv.put(TOUR8_11, team8);
//        cv.put(TOUR8_12, team1Status);
//        cv.put(TOUR8_13, team2Status);
//        cv.put(TOUR8_14, team3Status);
//        cv.put(TOUR8_15, team4Status);
//        cv.put(TOUR8_16, team5Status);
//        cv.put(TOUR8_17, team6Status);
//        cv.put(TOUR8_17, team7Status);
//        cv.put(TOUR8_19, team8Status);
//
//        long result = db.insert(TOURN4_NAME, null, cv);
//        if(result == -1){
//            return false;
//        }
//        else{
//            return true;
//        }
//    }

    public Cursor getTeamData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TEAMS_TABLE_NAME, null);
        return res;
    }

    public Cursor getTourn4Data(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TOURNAMENTS_4_TABLE_NAME, null);
        return res;
    }
//    public Cursor getTourn8Data(){
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor res = db.rawQuery("select * from " + TOURN8_NAME, null);
//        return res;
//    }

    public void returnTeamData(){
        Cursor res = getTeamData();
        if(res.getCount() == 0){
            /* There is no data in the table*/
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            /* This will show the team's data, but not their status, this is only for display purposes. */
            buffer.append("ID :"+ res.getInt(0)+ "\n|");
            buffer.append("Team Name :"+ res.getString(1)+ "\n|");
            buffer.append("Team Comments :"+ res.getString(2)+ "\n|");
        }
    }

    public void returnTourn4Data(){
        Cursor res = getTourn4Data();

        if(res.getCount() == 0){
            /* There is no data in the table*/
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()) {
            /* This will show the team's in the 4 team tournament, but not their status, this is only for display purposes. */
            buffer.append("ID :" + res.getString(0) + "\n|");
            buffer.append("Tournament Name :" + res.getString(1) + "\n|");
            buffer.append("Team 1 :" + res.getString(2) + "\n|");
            /* This will give you the PK of the team from the team database, will need to convert to the Team Name here */
            buffer.append("Team 2 :" + res.getInt(3) + "\n|");
            buffer.append("Team 3 :" + res.getInt(4) + "\n|");
            buffer.append("Team 4 :" + res.getInt(5) + "\n|");
            buffer.append("Tournament Style :" + res.getInt(6) + "\n|");

        }
    }

//    public void returnTourn8Data(){
//        Cursor res = getTourn4Data();
//
//        if(res.getCount() == 0){
//            /* There is no data in the table*/
//            return;
//        }
//        StringBuffer buffer = new StringBuffer();
//        while(res.moveToNext()) {
//            /* This will show the team's in the 8 team tournament, but not their status, this is only for display purposes. */
//            buffer.append("ID :" + res.getString(0) + "\n|");
//            buffer.append("Tournament Name :" + res.getString(1) + "\n|");
//            buffer.append("Tournament Type :" + res.getString(2) + "\n|");
//            /* This will give you the PK of the team from the team database, will need to convert to the Team Name here */
//            buffer.append("Team 1 :" + res.getInt(3) + "\n|");
//            buffer.append("Team 2 :" + res.getInt(4) + "\n|");
//            buffer.append("Team 3 :" + res.getInt(5) + "\n|");
//            buffer.append("Team 4 :" + res.getInt(6) + "\n|");
//            buffer.append("Team 5 :" + res.getInt(7) + "\n|");
//            buffer.append("Team 6 :" + res.getInt(8) + "\n|");
//            buffer.append("Team 7 :" + res.getInt(9) + "\n|");
//            buffer.append("Team 8 :" + res.getInt(10) + "\n\n|");
//        }
//    }
}
