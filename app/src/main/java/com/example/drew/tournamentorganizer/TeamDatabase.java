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
    _________________________________________________
    |_TeamID_|_teamName_|_teamCaptain_|_matchRating__|
    |________|__________|_____________|______________|
     */
    public static final String TABLE_NAME = "teamTable";

    public static final String COL_1 = "teamID";
    public static final String COL_2 = "teamName";
    public static final String COL_3 = "teamCaptain";
    public static final String COL_4 = "matchRating";
    /*
    __________________________________________________________
    |_TournamentID_|_tournamentName_|_team1..._|_team1Status__|
    |______________|________________|__________|______________|
    */
    public static final String TOURN4_NAME = "tourn4Table";
    public static final String TOUR4_1 = "tournamentID";
    public static final String TOUR4_2 = "tournamentName";
    public static final String TOUR4_3 = "tournamentType";
    public static final String TOUR4_4 = "team1";
    public static final String TOUR4_5 = "team2";
    public static final String TOUR4_6 = "team3";
    public static final String TOUR4_7 = "team4";
    public static final String TOUR4_8 = "team1Status";
    public static final String TOUR4_9 = "team2Status";
    public static final String TOUR4_10 = "team3Status";
    public static final String TOUR4_11 = "team4Status";
    //TODO: Add more tables for 16 team tournaments
    public static final String TOURN8_NAME = "tourn8Table";
    public static final String TOUR8_1 = "tournamentID";
    public static final String TOUR8_2 = "tournamentName";
    public static final String TOUR8_3 = "tournamentType";
    public static final String TOUR8_4 = "team1";
    public static final String TOUR8_5 = "team2";
    public static final String TOUR8_6 = "team3";
    public static final String TOUR8_7 = "team4";
    public static final String TOUR8_8 = "team5";
    public static final String TOUR8_9 = "team6";
    public static final String TOUR8_10 = "team7";
    public static final String TOUR8_11 = "team8";
    public static final String TOUR8_12 = "team1Status";
    public static final String TOUR8_13 = "team2Status";
    public static final String TOUR8_14 = "team3Status";
    public static final String TOUR8_15 = "team4Status";
    public static final String TOUR8_16 = "team5Status";
    public static final String TOUR8_17 = "team6Status";
    public static final String TOUR8_18 = "team7Status";
    public static final String TOUR8_19 = "team8Status";
    //public static final String TABLE_NAME = "teamTable";

    public TeamDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +
                " (teamID INTEGER PRIMARY KEY AUTOINCREMENT, teamName TEXT,  teamCaptain TEXT, matchRating INT)");

        db.execSQL("create table " + TOURN4_NAME + " (tournamentID INTEGER PRIMARY KEY AUTOINCREMENT, tournamentName TEXT, tournamentType TEXT, team1 TEXT,team1Status INT, team2 TEXT, team2Status INT,team3 TEXT,team3Status INT,team4 TEXT,team4Status INT)");

        db.execSQL("create table " + TOURN8_NAME + " (tournamentID INTEGER PRIMARY KEY AUTOINCREMENT, tournamentName TEXT, tournamentType TEXT, team1 TEXT,team1Status INT, team2 TEXT, team2Status INT,team3 TEXT,team3Status INT,team4 TEXT,team4Status INT, team5 TEXT,team5Status INT, team6 TEXT, team6Status INT,team7 TEXT,team7Status INT,team8 TEXT,team8Status INT)");
    }
    /* Only call this if you want to delete everything in the database and start over. */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TOURN4_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TOURN8_NAME);
        onCreate(db);
    }
    public boolean addTeam(String teamName, String teamCaptain, int matchRating){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_2, teamName);
        cv.put(COL_3, teamCaptain);
        cv.put(COL_4, matchRating);
        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean addTourn4(String tournamentName, String tournamentType, int team1, int team2, int team3, int team4, int team1Status, int team2Status, int team3Status, int team4Status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TOUR4_2, tournamentName);
        cv.put(TOUR4_3, tournamentType);
        cv.put(TOUR4_4, team1);
        cv.put(TOUR4_5, team2);
        cv.put(TOUR4_6, team3);
        cv.put(TOUR4_7, team4);
        cv.put(TOUR4_8, team1Status);
        cv.put(TOUR4_9, team2Status);
        cv.put(TOUR4_10, team3Status);
        cv.put(TOUR4_11, team4Status);

        long result = db.insert(TOURN4_NAME, null, cv);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean addTourn8(String tournamentName, String tournamentType, int team1, int team2, int team3, int team4, int team5, int team6, int team7, int team8 ,int team1Status, int team2Status, int team3Status, int team4Status, int team5Status, int team6Status, int team7Status, int team8Status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TOUR8_2, tournamentName);
        cv.put(TOUR8_3, tournamentType);
        cv.put(TOUR8_4, team1);
        cv.put(TOUR8_5, team2);
        cv.put(TOUR8_6, team3);
        cv.put(TOUR8_7, team4);
        cv.put(TOUR8_8, team5);
        cv.put(TOUR8_9, team6);
        cv.put(TOUR8_10, team7);
        cv.put(TOUR8_11, team8);
        cv.put(TOUR8_12, team1Status);
        cv.put(TOUR8_13, team2Status);
        cv.put(TOUR8_14, team3Status);
        cv.put(TOUR8_15, team4Status);
        cv.put(TOUR8_16, team5Status);
        cv.put(TOUR8_17, team6Status);
        cv.put(TOUR8_17, team7Status);
        cv.put(TOUR8_19, team8Status);

        long result = db.insert(TOURN4_NAME, null, cv);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public Cursor getTeamData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public Cursor getTourn4Data(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TOURN4_NAME, null);
        return res;
    }
    public Cursor getTourn8Data(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TOURN8_NAME, null);
        return res;
    }


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
            buffer.append("Team Captain :"+ res.getString(2)+ "\n|");
            buffer.append("Match Rating :"+ res.getInt(3)+ "\n\n|");
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
            buffer.append("Tournament Type :" + res.getString(2) + "\n|");
            /* This will give you the PK of the team from the team database, will need to convert to the Team Name here */
            buffer.append("Team 1 :" + res.getInt(3) + "\n|");
            buffer.append("Team 2 :" + res.getInt(4) + "\n|");
            buffer.append("Team 3 :" + res.getInt(5) + "\n|");
            buffer.append("Team 4 :" + res.getInt(6) + "\n\n|");
        }
    }
    public void returnTourn8Data(){
        Cursor res = getTourn4Data();

        if(res.getCount() == 0){
            /* There is no data in the table*/
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()) {
            /* This will show the team's in the 8 team tournament, but not their status, this is only for display purposes. */
            buffer.append("ID :" + res.getString(0) + "\n|");
            buffer.append("Tournament Name :" + res.getString(1) + "\n|");
            buffer.append("Tournament Type :" + res.getString(2) + "\n|");
            /* This will give you the PK of the team from the team database, will need to convert to the Team Name here */
            buffer.append("Team 1 :" + res.getInt(3) + "\n|");
            buffer.append("Team 2 :" + res.getInt(4) + "\n|");
            buffer.append("Team 3 :" + res.getInt(5) + "\n|");
            buffer.append("Team 4 :" + res.getInt(6) + "\n|");
            buffer.append("Team 5 :" + res.getInt(7) + "\n|");
            buffer.append("Team 6 :" + res.getInt(8) + "\n|");
            buffer.append("Team 7 :" + res.getInt(9) + "\n|");
            buffer.append("Team 8 :" + res.getInt(10) + "\n\n|");
        }
    }
}
