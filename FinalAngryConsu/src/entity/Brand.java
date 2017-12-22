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
public class Brand {
    private String id;
    private String name;
    private String industry;
    //private String sub; 필요 없을 것 같은데;; 굳이

    public Brand(){}
    public Brand(String id, String name, String industry) {
        this.id = id;
        this.name = name;
        this.industry = industry;
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

}
