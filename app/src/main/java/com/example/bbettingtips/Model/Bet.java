package com.example.bbettingtips.Model;

public class Bet {
    String hometeam, awayteam, odds, prediction, status, time, timeadded;

    public Bet(String hometeam, String awayteam, String odds, String prediction, String status, String time, String timeadded) {
        this.hometeam = hometeam;
        this.awayteam = awayteam;
        this.odds = odds;
        this.prediction = prediction;
        this.status = status;
        this.time = time;
        this.timeadded = timeadded;

    }

    public Bet() {
    }

    public String getHometeam() {
        return hometeam;
    }

    public String getTimeadded() {
        return timeadded;
    }

    public void setTimeadded(String timeadded) {
        this.timeadded = timeadded;
    }

    public void setHometeam(String hometeam) {
        this.hometeam = hometeam;
    }

    public String getAwayteam() {
        return awayteam;
    }

    public void setAwayteam(String awayteam) {
        this.awayteam = awayteam;
    }

    public String getOdds() {
        return odds;
    }

    public void setOdds(String odds) {
        this.odds = odds;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
