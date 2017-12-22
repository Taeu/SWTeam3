/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public class UserCustomer extends User{
    private String name;
    private String gender;
    private String birth; 
    private String phone;
    private String job;
    private LinkedList<Complaint> complaints= new LinkedList<Complaint>();
    
    public UserCustomer(String name, String gender, String birth, String phone, String job, String id, String password, String email, String num, int numComplaint) {
        super(id, password, email, num, numComplaint);
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.phone = phone;
        this.job = job;
    }

    private void complainWrite(){
        
    }
    private void ratingWrite(){
        
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
    
    
    
}
