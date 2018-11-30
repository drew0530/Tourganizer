package com.example.drew.tournamentorganizer;

public class TeamCard {
    private String teamName, teamComments;
    private int teamID;

    public TeamCard(int teamID, String teamName, String teamComments) {
        this.teamName = teamName;
        this.teamComments = teamComments;
        this.teamID = teamID;
    }

    public int getTeamID() { return teamID; }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamComments() {
        return teamComments;
    }
}
