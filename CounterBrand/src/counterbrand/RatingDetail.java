/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counterbrand;

import java.util.HashMap;

/**
 *
 * @author LENOVO
 */
public class RatingDetail {
    private int overallRating;
    private int speedRating;
    private int specificityRating;
    private int processRating;
    

    public RatingDetail(int overallRating, int speedRating, int specificityRating, int processRating) {
        this.overallRating = overallRating;
        this.speedRating = speedRating;
        this.specificityRating = specificityRating;
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

    public int getSpecificityRating() {
        return specificityRating;
    }


}
