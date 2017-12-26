/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author user
 */
public class Rating {
    private int overallRating;
    private int speedRating;
    private int detailednessRating;
    private int processRating;

    public Rating(int overallRating, int speedRating, int detailednessRating, int processRating) {
        this.overallRating = overallRating;
        this.speedRating = speedRating;
        this.detailednessRating = detailednessRating;
        this.processRating = processRating;
    }

    public int getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(int overallRating) {
        this.overallRating = overallRating;
    }

    public int getSpeedRating() {
        return speedRating;
    }

    public void setSpeedRating(int speedRating) {
        this.speedRating = speedRating;
    }

    public int getdetailednessRating() {
        return detailednessRating;
    }

    public void setdetailednessRating(int detailednessRating) {
        this.detailednessRating = detailednessRating;
    }

    public int getProcessRating() {
        return processRating;
    }

    public void setProcessRating(int processRating) {
        this.processRating = processRating;
    }
    
    
    
}
