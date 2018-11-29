package com.example.drew.tournamentorganizer;

public class TeamCard {
    private String teamName, teamCaptain;
    private int matchRating;

    public TeamCard(String teamName, String teamCaptain, int matchRating) {
        this.teamName = teamName;
        this.teamCaptain = teamCaptain;
        this.matchRating = matchRating;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamCaptain() {
        return teamCaptain;
    }

    public int getRating() {
        return matchRating;
    }
}
