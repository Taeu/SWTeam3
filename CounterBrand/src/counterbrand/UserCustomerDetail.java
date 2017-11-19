/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counterbrand;

/**
 *
 * @author JAEHOON
 */
public class UserCustomerDetail {
    private  String num;
    private  String id;
    private  String password;
    private  String name;
    private  String gender;
    private  String birth;
    private  String email;
    private  String phone;
    private  String job;
    static private int count;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public UserCustomerDetail(String num, String id, String password, String name, String gender, String birth, String email, String phone, String job) {
        this.num = num;
        this.id = id;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.email = email;
        this.phone = phone;
        this.job = job;
    }
    

    public UserCustomerDetail(String num, String id, String password, String name, String gender, String birth, String email, String phone) {
        this.num = num;
        this.id = id;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.email = email;
        this.phone = phone;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        UserCustomerDetail.count = count;
    }
    
    
    
    
}
