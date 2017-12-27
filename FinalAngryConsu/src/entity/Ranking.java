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
public class Ranking {
    private Brand brand;
    private int BCI;
    private Rating rating;
    private int numComplaint;

    private int rank;

    public Ranking(Brand brand, int BCI, Rating rating, int numComplaint) {
        this.brand = brand;
        this.BCI = BCI;
        this.rating = rating;
        this.numComplaint = numComplaint;
        this.rank = 0;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

  

    public int getBCI() {
        return BCI;
    }

    public void setBCI(int BCI) {
        this.BCI = BCI;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public int getNumComplaint() {
        return numComplaint;
    }

    public void setNumComplaint(int numComplaint) {
        this.numComplaint = numComplaint;
    }
    
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    
}
