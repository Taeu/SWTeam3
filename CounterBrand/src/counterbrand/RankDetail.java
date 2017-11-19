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
public class RankDetail {
    private String id;
    private String name;
    private String industry;
    private String sub;
    private String rankTime;
    private String count;
    
    //private RatingDetail ratingDetail;
    
    public RankDetail(String id, String name, String industry, String sub, String rankTime, String count) {
        this.id = id;
        this.name = name;
        this.industry = industry;
        this.sub = sub;
        this.rankTime = rankTime;
        this.count = count;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTime() {
        return rankTime;
    }

    public void setTime(String rankTime) {
        this.rankTime = rankTime;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    
    
}
