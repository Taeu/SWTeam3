/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaehoon;

/**
 *
 * @author JAEHOON
 */
public class UserCustomerDetail extends UserDetail{
    private  String name;
    private  String gender;
    private  String birth;
    private  String phone;
    private  String job;
    
    public UserCustomerDetail(String num, String id, String password, String name, String gender, String birth, String email, String phone, String job, String type) {
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.phone = phone;
        this.job = job;
        setId(id);
        setEmail(email);
        setNum(num);
        setPassword(password);
        setType(type);
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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
        
}
