/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counterbrand;

import java.lang.String;
import javafx.beans.property.StringProperty;

/**
 *
 * @author user
 */
public class ComplainDetail {

    private String id;
    private String name;
    private String industry;
    private String sub;
    private String time;
    private String content;
    private String title;
    private FeedbackDetail feedbackDetail = new FeedbackDetail();
    //private RatingDetail ratingDetail;
   // private int feedbackIsCompleted;
    public ComplainDetail(){}
    
    public ComplainDetail(String id, String industry, String name, String sub, String time, String title, String content) {
        this.id = new String(id);
        this.name = new String(name);
        this.industry = new String(industry);
        this.sub = new String(sub);
        this.time = new String(time);
        this.content = new String(content);
        this.title = new String(title);
    }
    
    public ComplainDetail(FeedbackDetail feedbackDetail){
        this.feedbackDetail = feedbackDetail;
    }
    /*
    public ComplainDetail(String id, String industry, String name, String sub, String time, String title, String content, FeedbackDetail feedbackDetail){
        this.id = new String(id);
        this.name = new String(name);
        this.industry = new String(industry);
        this.sub = new String(sub);
        this.time = new String(time); 
        this.content = new String(content);
        this.title = new String(title);
        this.feedbackDetail.setFeedbackContent(feedbackDetail.getContent());
        this.feedbackDetail.setTimeEnd(feedbackDetail.getTimeEnd());
    }
    */
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return this.industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getSub() {
        return this.sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    /*
    public FeedbackDetail getFeedbackDetail(){
        return this.feedbackDetail;
    }
    
    public void setFeedbackDetail(FeedbackDetail feedbackDetail){
        this.feedbackDetail = feedbackDetail;
    }
    */
        /*수정
    public int remainTime(){
        return dif(this.time, ratingDetail.time);
    
    }*/
}
