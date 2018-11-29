package com.example.drew.tournamentorganizer;

public class TeamCard {
    private String teamName, teamComments;

    public TeamCard(String teamName, String teamComments) {
        this.teamName = teamName;
        this.teamComments = teamComments;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamComments() {
        return teamComments;
    }
}
