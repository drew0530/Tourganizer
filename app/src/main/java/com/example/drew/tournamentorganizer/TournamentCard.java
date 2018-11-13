package com.example.drew.tournamentorganizer;

import java.text.SimpleDateFormat;

/**
 * Created by Drew on 11/5/18.
 */

public class TournamentCard {

    private String tournamentName, team1Name, team2Name;
    private String date;
    private int team1Image, team2Image;

    public TournamentCard(String tournamentName, String team1Name, String team2Name, String date, int team1Image, int team2Image) {
        this.tournamentName = tournamentName;
        this.team1Name = team1Name;
        this.team2Name = team2Name;
        this.date = date;
        this.team1Image = team1Image;
        this.team2Image = team2Image;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public String getTeam1Name() {
        return team1Name;
    }

    public String getTeam2Name() {
        return team2Name;
    }

    public String getDate() {
        return date;
    }

    public int getTeam1Image() {
        return team1Image;
    }

    public int getTeam2Image() {
        return team2Image;
    }
}
