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
    private String num; // private 키
    private String id;  // customer id를 넣는 것이 좋겠다.
    private String title;
    private String content;
    private String time;
    private Feedback feedback;  //feedback이 완성되면 받아와야함 
    private Rating rating;      // rating이 완성되면 그냥 그 Rating을 받아옴
    private Brand brand;
    private String sub;
    private String status;      // 1 feedback 2 rating 3

    public Complaint(String num, String id, String title, String content, String time, Feedback feedback, Rating rating, Brand brand, String sub, String status) {
        this.num = num;
        this.id = id;
        this.title = title;
        this.content = content;
        this.time = time;
        this.feedback = feedback;
        this.rating = rating;
        this.brand = brand;
        this.sub = sub;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Complaint(String num, String id, String title, String content, String time, Brand brand, String sub){
        this.num = num;
        this.id = id;
        this.title = title;
        this.content = content;
        this.time =time;
        this.brand = brand;
        this.sub = sub;
        this.status = "1";
        this.feedback = new Feedback("0","0");
        this.rating = new Rating(0,0,0,0);
    }
    public Complaint(String num, String id, String title, String content, String time, Brand brand, String sub, String status) {
        this.num = num;
//        this.id = id;
        this.title = title;
        this.content = content;
        this.time = time;
       
        this.brand = brand;
        this.sub = sub;
        this.status = status;
    }

    
    
    
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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
