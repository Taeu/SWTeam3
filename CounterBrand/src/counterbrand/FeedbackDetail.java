/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counterbrand;

/**
 *
 * @author Taeu
 */
public class FeedbackDetail {
    private  String content;
    private  String timeEnd;
    
    FeedbackDetail(String content, String timeEnd){
        this.content= new String(content);
        this.timeEnd= new String(timeEnd);
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
   
    
}
