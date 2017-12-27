/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others;

import entity.Brand;
import entity.Feedback;
import entity.Rating;

/**
 *
 * @author user
 */
public class complaintDetail {
    private String num; // private 키
    private String id;  // customer id를 넣는 것이 좋겠다.
    private String title;
    private String content;
    private String time;
    private String brandid;
    private String name;
    private String industry;
    private String sub;
    private String feedbackContent;
    private String feedbackTimeend;
    private String overallRating;
    private String speedRating;
    private String detailednessRating;
    private String processRating;
    private String status;

    public complaintDetail(String num, String id, String title, String content, String time, String brandid, String name, String industry, String sub, String feedbackContent, String feedbackTimeend, String overallRating, String speedRating, String detailednessRating, String processRating, String status) {
        this.num = num;
        this.id = id;
        this.title = title;
        this.content = content;
        this.time = time;
        this.brandid = brandid;
        this.name = name;
        this.industry = industry;
        this.sub = sub;
        this.feedbackContent = feedbackContent;
        this.feedbackTimeend = feedbackTimeend;
        this.overallRating = overallRating;
        this.speedRating = speedRating;
        this.detailednessRating = detailednessRating;
        this.processRating = processRating;
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

    public String getBrandid() {
        return brandid;
    }

    public void setBrandid(String brandid) {
        this.brandid = brandid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public String getFeedbackTimeend() {
        return feedbackTimeend;
    }

    public void setFeedbackTimeend(String feedbackTimeend) {
        this.feedbackTimeend = feedbackTimeend;
    }

    public String getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(String overallRating) {
        this.overallRating = overallRating;
    }

    public String getSpeedRating() {
        return speedRating;
    }

    public void setSpeedRating(String speedRating) {
        this.speedRating = speedRating;
    }

    public String getDetailednessRating() {
        return detailednessRating;
    }

    public void setDetailednessRating(String detailednessRating) {
        this.detailednessRating = detailednessRating;
    }

    public String getProcessRating() {
        return processRating;
    }

    public void setProcessRating(String processRating) {
        this.processRating = processRating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
}
