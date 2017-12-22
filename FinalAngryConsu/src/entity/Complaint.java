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
public class Complaint {
    private String id;
    private String title;
    private String content;
    private String time;
    private int feedbackIsCompleted;
    private int ratingIsCompleted;
    private Feedback feedback;  //feedback이 완성되면 받아와야함 
    private Rating rating;      // rating이 완성되면 그냥 그 Rating을 받아옴
    private Brand brand;
    private String sub;

    public Complaint(String id, String title, String content, String time, int feedbackIsCompleted, int ratingIsCompleted, Brand brand, String sub) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.time = time;
        this.feedbackIsCompleted = feedbackIsCompleted;
        this.ratingIsCompleted = ratingIsCompleted;
        this.brand = brand;
        this.sub = sub;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getFeedbackIsCompleted() {
        return feedbackIsCompleted;
    }

    public void setFeedbackIsCompleted(int feedbackIsCompleted) {
        this.feedbackIsCompleted = feedbackIsCompleted;
    }

    public int getRatingIsCompleted() {
        return ratingIsCompleted;
    }

    public void setRatingIsCompleted(int ratingIsCompleted) {
        this.ratingIsCompleted = ratingIsCompleted;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }
}
