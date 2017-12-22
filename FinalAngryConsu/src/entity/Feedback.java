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
public class Feedback {
    private String content;
    private String timeEnd;

    public Feedback(String content, String timeEnd) {
        this.content = content;
        this.timeEnd = timeEnd;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }
    
    private void show(){
        
    }
}
